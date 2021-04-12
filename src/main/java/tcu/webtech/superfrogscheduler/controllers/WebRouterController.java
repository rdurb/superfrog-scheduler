package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.CustomUserDetails;

@Controller
public class WebRouterController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        System.out.println(currentUser.toString());

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        System.out.println("User firstname: " + user.getFirstName());
        System.out.println("User lastname: " + user.getLastName());
        System.out.println("User email: " + user.getEmail());
        System.out.println("User password: " + user.getPassword());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        // On success, go to login page
        return "/success";
    }

    @RequestMapping("/success")
    public String success() {
        System.out.println(userRepository.findAll());
        return "/";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }

}
