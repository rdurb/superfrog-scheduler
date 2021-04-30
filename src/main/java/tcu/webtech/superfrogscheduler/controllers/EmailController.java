package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.EmailService;

@RestController
@Controller
public class EmailController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/eventmanagement/assign/{userEmail}")
    public String assign(@PathVariable("userEmail") String email) {
        User user = userRepository.findByEmail(email);
        emailService.sendEmail(user);
        return "A Superfrog has been assigned to the event.";
    }
}
