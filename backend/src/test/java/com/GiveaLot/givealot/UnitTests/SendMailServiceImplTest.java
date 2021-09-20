package com.GiveaLot.givealot.UnitTests;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.service.SendMailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SendMailServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class SendMailServiceImplTest {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private SendMailServiceImpl sendMailServiceImpl;

    @Test
    public void testSendMail() throws MailException {
        doNothing().when(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
        this.sendMailServiceImpl
                .sendMail(new Mail("test", "test", "test"));
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
    }

    @Test
    public void testSendMailSet() throws MailException {
        doNothing().when(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());

        Mail mail = new Mail("test", "test", "rest");
        mail.setSubject("test");
        this.sendMailServiceImpl.sendMail(mail);
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
    }

}

