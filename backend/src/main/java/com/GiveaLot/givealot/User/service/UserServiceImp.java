package com.GiveaLot.givealot.User.service;

import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.service.SendMailServiceImpl;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import com.GiveaLot.givealot.User.requests.*;
import com.GiveaLot.givealot.User.response.UserResponse;
import com.GiveaLot.givealot.User.response.userResponseGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SendMailServiceImpl sendMailService;

    @Override /*tested - all good*/
    public userResponseGeneral Register(RegisterUserRequest request) throws Exception{
        if (request == null) {
            throw new Exception("Registration not set");
        }
        if(request.getEmail()==null)
        {
            throw new Exception("Registration not set, email not valid");
        }
        User userEmail = userRepository.findUserByEmail(request.getEmail());
        if (userEmail != null) {
            throw new  Exception("The email has already been taken.");
        }

        if(request.getFirstName()==null || request.getFirstName().isEmpty())
        {
            throw new Exception("Registration not set, firstname not valid");
        }
        if(request.getLastName() == null || request.getLastName().isEmpty()){
            throw new Exception("Registration not set, lastname not valid");

        }
        if (request.getPassword() == null || request.getPassword().isEmpty())
        {
            throw new Exception("Registration not set, password not valid");

        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);
        request.setPassword(salted);

        User newUser = request.getUser();
        newUser.setAdmin(false);

        Date dateCurrent = new Date();
        Date dateEx = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateCreated = format.format(dateCurrent);
        newUser.setActivateDate(dateCreated);

        userRepository.save(newUser);
        /**Sending a verification email**/
        System.out.println("Sending Email...");

        Mail mail = new Mail(newUser.getEmail(),"Givealot SignUp Verification","Congratulations your you have successfully signed up to the Givealot platform" +
                "\n We are please to be working with you to provide a safe space were user's can donate to authentic organisations" +
                "\n" +
                "\n" +
                "Kind Regards \n" +
                "Givealot Team");

        sendMailService.sendMail(mail);
        System.out.println("Email sent successfully");
       return new userResponseGeneral("add_user_200_ok","success");
    }

    @Override /* tested - all good */
    public userResponseGeneral ResetPasswordRequest(ResetPasswordRequestRequest request) throws Exception{
        if (request == null) {
            throw new Exception("Exception: Reset not set");
        }

        else if(request.getEmail() == null || request.getNewPassword() == null ) {
            throw new Exception("Exception: null field(s) provided");
        }

        else if(request.getEmail().isEmpty() || request.getNewPassword().isEmpty()) {
            throw new Exception("Exception: empty field(s) provided");
        }

        User currentUser = userRepository.findUserByEmail(request.getEmail());
        if(currentUser == null)
        {
            throw new Exception("this user is not registered");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getNewPassword() + salt);

        userRepository.updatePassword(currentUser.getEmail(),salted);
        return new userResponseGeneral("res_pass_200_ok","success");
    }

    @Override /* tested - all good */
    public userResponseGeneral SetAdmin(SetAdminRequest request) throws Exception {
        if (request == null) {
            throw new Exception("Please send a valid request object.");
        }

        if(request.getAdminEmail() == null)
        {
            throw new Exception("admin email empty");
        }
        else if(request.getGeneralUserEmail() == null)
        {
            throw new Exception("general user field empty");
        }

        User Admin = userRepository.findUserByEmail(request.getAdminEmail());

        if (Admin==null) {
            throw new Exception( "The admin user trying to call setAdmin was not found.");
        }

        if(!Admin.getAdmin())
        {
            throw new Exception( "The current user is not an admin user");
        }
        User generalUser = userRepository.findUserByEmail(request.getGeneralUserEmail());

        if(generalUser == null)
            throw new Exception("Exception: user not found by their email");

        if (userRepository.updateAdmin(generalUser.getEmail(), true) == 0) {
            throw new Exception( "The update did not occur correctly. Please try again.");
        }

        /**Sending a verification email**/
        System.out.println("Sending Email...");

        Mail mail = new Mail(generalUser.getEmail(),"Role Change","Congratulations your you have successfully promoted to the role of an admin in the Givealot platform" +
                "\n We are please to be working with you to provide a safe space were user's can donate to authentic organisations" +
                "\n" +
                "\n" +
                "Kind Regards \n" +
                "Givealot Team");

        sendMailService.sendMail(mail);
        System.out.println("Email sent successfully");
        return new userResponseGeneral("set_ad_200_ok","success");
    }

    @Override /*tested all good*/
    public User getUser(GetUserRequest request) throws Exception{

        if (request == null){
            throw new Exception("Please send a valid request object.");
        }
        else if(request.getAdminUser() == null || request.getAdminUser().isEmpty()) {
            throw new Exception("admin email not set");
        }
        else if(request.getGeneralUserEmail() == null || request.getGeneralUserEmail().isEmpty())
        {
            throw new Exception("user email not set");
        }

        User admin = userRepository.findUserByEmail(request.getAdminUser());

        if(!admin.getAdmin())
        {
            throw new UserNotAuthorisedException("current user is not an admin");
        }

        User res = userRepository.findUserByEmail(request.getGeneralUserEmail());

        if(res == null)
        {
            throw new Exception("user does not exist");
        }

        return res;
    }

    @Override /*tested all good*/
    public List<User> GetUsers(GetUsersRequest request) throws Exception
        {
            if(request == null)
            {
                throw new Exception("Exception: request not set");
            }
            if(request.getAdminUser() == null)
            {
                throw new Exception("Exception: admin user field not set");
            }
            else if(request.getAdminUser().isEmpty())
            {
                throw new Exception("Exception: admin user field is empty");
            }

            User admin = userRepository.findUserByEmail(request.getAdminUser());

            if(admin == null)
                throw new Exception("Exception: user is not admin");


            if(!admin.getAdmin())
            {
                throw new UserNotAuthorisedException("current user is not an admin");
            }

            return userRepository.findAll();
        }

    public String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
