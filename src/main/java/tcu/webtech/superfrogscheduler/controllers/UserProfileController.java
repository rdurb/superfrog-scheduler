package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

@Controller
public class UserProfileController {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("user", currentUser);
        model.addAttribute("editUser", new User());
        return "profile";
    }

    @PostMapping(value="/profile/update")
    public String updateUser(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("user", currentUser);
        model.addAttribute("editUser", new User());
        System.out.println("here");
        return "updateuser";
    }

    @PostMapping(value="/profile/update/{email}")
    public String updateUsers(@PathVariable("email") String email, @ModelAttribute("editUser") User user) {
        System.out.println(user);
        User oldUser = userRepository.findByEmail(email);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(oldUser);
        return "update_success";
    }

    @PostMapping(value="/profile/changepwd")
    public String ChangePwd(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("user", currentUser);
        model.addAttribute("editUser", new User());
        System.out.println("here1");
        return "changepwd";
    }

    @PostMapping(value="/profile/changepwd/{email}")
    public String ChangePwds(@PathVariable("email") String email, @ModelAttribute("editUser") User user) {
        User oldUser = userRepository.findByEmail(email);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);
        if(user.getPassword()!= "") oldUser.setPassword(encodedPassword);
        userRepository.save(oldUser);
        return "update_success";
    }

}
