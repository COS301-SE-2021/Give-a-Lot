package com.GiveaLot.givealot.User.service;

import com.GiveaLot.givealot.User.dao.UserDAOInterface;
import com.GiveaLot.givealot.User.exception.InvalidCredentialException;
import com.GiveaLot.givealot.User.exception.ResetPasswordTimedOutException;
import com.GiveaLot.givealot.User.exception.UserAlreadyValidationAccountException;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.model.User;
import com.GiveaLot.givealot.User.rri.VerifyAccountResponse;
import com.GiveaLot.givealot.User.rri.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    UserDAOInterface userDAO;

    private final PasswordEncoder passwordEncoder;
    private final boolean byPassEmail;

    @Autowired
    public UserServiceImpl() {
        passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        byPassEmail = false;
    }

    @Override
    public RegisterUserResponse Register(RegisterUserRequest request){
        if (request == null) {
            return new RegisterUserResponse(false, "Please use a valid RegisterUserRequest Object.");
        }



        User userEmail = userDAO.findUserByEmail(request.getEmail());

        if (userEmail != null) {
            return new RegisterUserResponse(false, "The email has already been taken.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User newUser;

        newUser = new User(request.getFirstName(), request.getLastName(), request.getEmail(), encodedPassword);


        String activationCode = RandomStringUtils.random(64, true, true);
        newUser.setActivationCode(activationCode);

        User checkIfSaved = userDAO.save(newUser);

        if (checkIfSaved != newUser) {
            return new RegisterUserResponse(false, "The user was not registered.");
        }

            return new RegisterUserResponse(true, "The user was registered successfully.");

    }

    @Override
    public VerifyAccountResponse VerifyAccount(VerifyAccountRequest request) throws UserAlreadyValidationAccountException {
        if (request == null) {
            return new VerifyAccountResponse(false, "Please use a valid VerifyAccountRequest Object.");
        }

        User currentUser = userDAO.findUserByEmail(request.getUsername());

        if (currentUser == null) {
            return new VerifyAccountResponse(false, "The username does not exist.");
        }


        if (currentUser.getActivateDate() != null) {
            throw new UserAlreadyValidationAccountException("The account has already been verified.");
        }

        if (!currentUser.getActivationCode().equals(request.getActivationCode())) {
            return new VerifyAccountResponse(false, "The wrong validation code was supplied.");
        }

        LocalDateTime currentTime = LocalDateTime.now();

        int saved = userDAO.setActivateDate(currentUser.getId(), currentTime);

        int retryCounter = 0;

        while ((saved == 0) && (retryCounter < 5)) {
            retryCounter++;
            saved = userDAO.setActivateDate(currentUser.getId(), currentTime);
        }

        if (saved > 0) {
            return new VerifyAccountResponse(true, "The account was successfully verified.");
        } else {
            return new VerifyAccountResponse(false, "The account failed to verify.");
        }
    }

    @Override
    public LoginUserResponse Login(LoginUserRequest request) throws InvalidCredentialException {
        return null;
    }

    /* @Override
     public LoginUserResponse Login(LoginUserRequest request) throws InvalidCredentialException {
         LocalDateTime currentTime = LocalDateTime.now();

         if (request == null) {
             return new LoginUserResponse(false, "Please use a valid LoginUserRequest Object.");
         }

         User foundUser = userDAO.findUserByEmail(request.getEmail());

         if (foundUser ==null) {
             throw new InvalidCredentialException("The username does not exist.");
         }


         if (foundUser.getActivateDate() == null) {
             return new LoginUserResponse(false, "The user has not yet been verified.");
         }

         if (!passwordEncoder.matches(request.getPassword(), foundUser.getPassword())) {
             throw new InvalidCredentialException("The password was incorrect.");
         }

         String token = generateJWTToken(foundUser, currentTime);

        User checkJWTToken = userDAO.findUserByJWTToken(token);

         while (checkJWTToken !=null) {
             token = generateJWTToken(foundUser, currentTime);

             checkJWTToken = userDAO.findUserByJWTToken(token);
         }

         int saved = userDAO.setJWTToken(foundUser.getId(), token);

         int retryCounter = 0;

         while ((saved == 0) && (retryCounter < 5)) {
             retryCounter++;
             saved = userDAO.setJWTToken(foundUser.getId(), token);
         }

         if (saved > 0) {
             userDAO.setLastLoggedIn(foundUser.getId(), currentTime);

             return new LoginUserResponse(true, "The user was logged in.");
         } else {
             return new LoginUserResponse(false, "The user was not logged in.");
         }    }
 */
    @Override
    public UpdateAccountInfoResponse UpdateAccountInfo(UpdateAccountInfoRequest request) {
        return null;
    }

    @Override
    public ResetPasswordRequestResponse ResetPasswordRequest(ResetPasswordRequestRequest request) {
        if (request == null) {
            return new ResetPasswordRequestResponse(false,"Please send a valid request object.");
        }

        User foundUser = userDAO.findUserByEmail(request.getEmail());

        if (foundUser == null) {
            return new ResetPasswordRequestResponse(false,"There is no user with the email: " + request.getEmail() + ".");
        }

        String resetCode = RandomStringUtils.random(64, true, true);

       User findByResetCode = userDAO.findUserByResetCode(resetCode);

        while (findByResetCode!=null) {
            resetCode = RandomStringUtils.random(64, true, true);

            findByResetCode = userDAO.findUserByResetCode(resetCode);
        }

        LocalDateTime resetExpiration = LocalDateTime.now().plusHours(4);


        int saved = userDAO.setResetExpirationAndResetCode(foundUser.getId(), resetExpiration, resetCode);
        int saveCounter = 0;

        while ((saved == 0) && (saveCounter < 3)) {
            saveCounter++;
            saved = userDAO.setResetExpirationAndResetCode(foundUser.getId(), resetExpiration, resetCode);
        }

        if (saved > 0) {
            return new ResetPasswordRequestResponse(true, "The password reset code email was sent and the data saved correctly.");
        } else {
            return new ResetPasswordRequestResponse(false, "There was an error.");
        }    }

    @Override
    public ResetPasswordFinalizeResponse ResetPasswordFinalize(ResetPasswordFinalizeRequest request) throws ResetPasswordTimedOutException {
        if (request == null) {
            return new ResetPasswordFinalizeResponse(false, "Please send a valid request object.");
        }

        User user = userDAO.findUserByResetCode(request.getValidationCode());

        if(user == null) {
            return new ResetPasswordFinalizeResponse(false, "This reset code does not exist.");
        }

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expiryTime = user.getResetExpiration();

        if (expiryTime == null) {
            return new ResetPasswordFinalizeResponse(false, "The expiration date is null.");
        }

        if (currentTime.isBefore(expiryTime)) {
            String hashedPassword = passwordEncoder.encode(request.getNewPassword());
            int saved = userDAO.updatePassword(request.getValidationCode(), hashedPassword);

            int saveCounter = 0;

            while ((saved == 0) && (saveCounter < 3)) {
                saveCounter++;
                saved = userDAO.updatePassword(request.getValidationCode(), hashedPassword);
            }

            if (saved > 0) {
                return new ResetPasswordFinalizeResponse(true, "The password has been updated.");
            } else {
                return new ResetPasswordFinalizeResponse(false, "There was an error updating the password.");
            }
        } else {
            throw new ResetPasswordTimedOutException("The reset code has expired.");
        }    }

    @Override
    public GetCurrentUserResponse GetCurrentUser(GetCurrentUserRequest request) {
        if (request == null) {
            return new GetCurrentUserResponse(false, "Please use a valid GetCurrentUserRequest Object.", null);
        }

        User userOptionalJwtToken = userDAO.findUserByJWTToken(request.getJWTToken());

        if (userOptionalJwtToken == null) {
            return new GetCurrentUserResponse(false, "There is no user with the specified JWT token.", null);
        } else {
            return new GetCurrentUserResponse(true, "The user with the specified JWT token was found.", userOptionalJwtToken);
        }    }

    @Override
    public SetAdminResponse SetAdmin(SetAdminRequest request) throws UserNotAuthorisedException {
        return null;
    }

    /* @Override
     public SetAdminResponse SetAdmin(SetAdminRequest request) throws UserNotAuthorisedException {
         if (request == null) {
             return new SetAdminResponse(false, "Please send a valid request object.");
         }

         User adminUser = userDAO.findUserByJWTToken(request.getJWTTokenOfCurrentAdmin());

         if (adminUser == null) {
             return new SetAdminResponse(false, "The admin user trying to call setAdmin was not found.");
         }


         if (!adminUser.getAdmin()) {
             throw new UserNotAuthorisedException("The user trying to call the function is not an admin.");
         }

         User userToChangeAdminStatus = userDAO.findById(request.getUserToChangeAdminStatus());

         if (userToChangeAdminStatus == null) {
             return new SetAdminResponse(false, "The user whose admin status you are trying to change was not found.");
         }

         int count = userDAO.updateAdmin(request.getUserToChangeAdminStatus(), request.isFlag());

         if (count == 0) {
             return new SetAdminResponse(false, "The update did not occur correctly. Please try again.");
         } else {
             return new SetAdminResponse(true, "The user's admin status was changed.");
         }
     }
 */
    @Override
    public GetUsersResponse GetUsers(GetUsersRequest request) throws UserNotAuthorisedException {
        if (request == null) {
            return new GetUsersResponse(false, "Please send a valid request object.", null);
        }

        User adminUser = userDAO.findUserByJWTToken(request.getJWTToken());

        if (adminUser == null) {
            return new GetUsersResponse(false, "The user with this JWT Token does not exist.", null);
        }

        if (!adminUser.getAdmin()) {
            throw new UserNotAuthorisedException("The user trying to call the function is not an admin.");
        }

        List<User> allUsers = userDAO.findAll();

        return new GetUsersResponse(true, "This object will have a list of users.", allUsers);    }


}
