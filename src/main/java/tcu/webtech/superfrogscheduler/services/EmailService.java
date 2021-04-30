package tcu.webtech.superfrogscheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tcu.webtech.superfrogscheduler.models.User;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(User user) throws MailException {
        SimpleMailMessage assignMail = new SimpleMailMessage();
        assignMail.setTo(user.getEmail());
        assignMail.setFrom("webtechsfscheduler@gmail.com");
        assignMail.setSubject("SuperFrog Assigned");
        assignMail.setText("Dear Customer," + "\n" + "We are glad to inform you that a super frog has been assigned to appear for your event. \n"
        + "For more informtion, please log in to your account.\n" +
                "Thank you!");
        javaMailSender.send(assignMail);
    }
}
