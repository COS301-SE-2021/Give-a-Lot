package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.model.PasswordResetToken;
import com.GiveaLot.givealot.Login.repository.*;
import com.GiveaLot.givealot.Login.request.*;
import com.GiveaLot.givealot.Login.response.*;
import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.dataclass.Notification;
import com.GiveaLot.givealot.Notification.service.SendMailServiceImpl;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.rmi.MarshalledObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    SendMailServiceImpl sendMailService;

    @Autowired
    PasswordResetRepository passwordResetRepository;

    public LoginResponse login(LoginRequest request) throws Exception
    {
        if(request == null)
        {
            throw new Exception("Exception: login request object is null");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is null");
        }
        else if(request.getEmail().trim().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }
        else if(request.getPassword() == null)
        {
            throw new Exception("Exception: password field is null");
        }
        else if(request.getPassword().trim().isEmpty()) {
            throw new Exception("Exception: password field is empty");
        }

        User user = userRepository.findUserByEmail(request.getEmail());

        if(user == null) {
            return this.loginOrganisation(request);
        }

        if(user.getAdmin())
        {
           return this.loginAdminUser(request);
        }
        else return this.loginGeneralUser(request);
    }

    @Override /*tested - works perfect*/
    public LoginResponse loginGeneralUser(LoginRequest request) throws Exception
    {
        if(request == null)
        {
            throw new Exception("Exception: login request object is null");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is null");
        }
        else if(request.getEmail().trim().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }
        else if(request.getPassword() == null)
        {
            throw new Exception("Exception: password field is null");
        }
        else if(request.getPassword().trim().isEmpty()) {
            throw new Exception("Exception: password field is empty");
        }

        User user = loginRepository.findUserByEmail(request.getEmail());

        if(user== null)
        {
            throw new Exception("password: user not found");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);

        if(!user.getPassword().equals(salted))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(request.getEmail().trim(),true,"User logged in successfully","general", user.getId());
    }

    @Override /*tested - works perfect*/
    public LoginResponse loginOrganisation(LoginRequest request)throws Exception
    {
        if(request == null)
        {
            throw new Exception("please send a valid request");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is null");
        }
        else if(request.getEmail().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }

        Organisations user = organisationRepository.selectOrganisationByEmail(request.getEmail());

        if(user == null)
        {
            throw new Exception("organisation not found");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);

        if(!user.getPassword().equals(salted))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(request.getEmail(),true,"User logged in succesfully","organisation",user.getOrgId());
    }

    @Override /*tested - works perfect*/
    public LoginResponse loginAdminUser(LoginRequest request) throws Exception
    {
        if(request == null)
        {
            throw new Exception("Exception: request object is not set");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is not set");
        }
        else if(request.getEmail().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }
        else if(loginRepository.findUserByEmail(request.getEmail()) == null)
        {
            throw new Exception("user not found");
        }

        User user = loginRepository.findUserByEmail(request.getEmail());

        if(!user.getAdmin())
        {
            throw new Exception("user is not an admin");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);

        if(!user.getPassword().equals(salted))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(request.getEmail(),true,"User logged in succesfully","admin", user.getId());
    }

    @Override
    public ForgotPasswordResponse forgotPassward(ForgotPasswordRequest body) throws Exception {
        if(body == null)
            throw new Exception("request is null");

       Organisations isOrganisations =organisationRepository.selectOrganisationByEmail(body.getEmail());
        User isUser = userRepository.findUserByEmail(body.getEmail());

        if(isOrganisations == null && isUser ==null)
            throw new Exception("this user does not exist, please re-check you email");
        String token = UUID.randomUUID().toString();

        PasswordResetToken myToken = new PasswordResetToken(token, body.getEmail());
        passwordResetRepository.save(myToken);
       // System.out.println(myToken.);
        /**Sending a verification email**/
        System.out.println("Sending Email...");

        Mail mail = new Mail(body.getEmail(),"Forgot Password","Hey there we understand it happens here's your token enter this to get access to change your password" +
                "\n Token: " +token+
                "\n" +
                "\n" +
                "Kind Regards \n" +
                "Givealot Team");

        sendMailService.sendMail(mail);
        System.out.println("Email sent successfully");

        return new ForgotPasswordResponse(true,"token sent");
    }

    @Override
    public ForgotPasswordResponse checkToken(TokenRequest body) throws Exception {
        if(body == null)
            throw new Exception("request is null");

        if(passwordResetRepository.findToken(body.getToken()) == null)
            throw new Exception("token does not exist");

        return new ForgotPasswordResponse(true,"token matched");
    }

    @Override
    public ForgotPasswordResponse changePassword(ChangePasswordRequest body) throws Exception {
        if(body == null)
            throw new Exception("request is null");
        Organisations isOrganisations =organisationRepository.selectOrganisationByEmail(body.getUserEmail());
        User isUser = userRepository.findUserByEmail(body.getUserEmail());

        if(isOrganisations == null && isUser ==null)
            throw new Exception("this user does not exist, please re-check you email");

        if(isOrganisations!=null)
        {
            String salt = getMd5(body.getUserEmail());
            String salted = getMd5(body.getPassword() + salt);
           organisationRepository.updatePassword(body.getUserEmail(),salted);
        }
        else
        {
            String salt = getMd5(body.getUserEmail());
            String salted = getMd5(body.getPassword() + salt);
            userRepository.updatePassword(body.getUserEmail(),salted);
        }
        return new ForgotPasswordResponse(true,"password reset successful");

    }

    public String getMd5(String input)
    {
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
