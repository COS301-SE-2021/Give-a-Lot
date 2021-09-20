package com.GiveaLot.givealot.Login.request;

import com.GiveaLot.givealot.Login.model.PasswordResetToken;
import com.GiveaLot.givealot.Login.repository.PasswordResetRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class createPasswordResetTokenForEmail {
    @Autowired
    PasswordResetRepository passwordResetRepository;

    public createPasswordResetTokenForEmail(@JsonProperty("email") String email,@JsonProperty("token") String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, email);
        passwordResetRepository.save(myToken);
    }
}
