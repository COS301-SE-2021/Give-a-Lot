package com.GiveaLot.givealot.Notification.service;
import com.GiveaLot.givealot.Notification.dataclass.Mail;

import javax.mail.MessagingException;

public interface SendMailService {
    void sendMail(Mail mail);
}
