package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.ERole;
import tcu.webtech.superfrogscheduler.models.Role;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.CustomUserDetails;

@Controller
public class WebRouterController {

    @Autowired
    private UserRepository userRepository;

    private Role r1 = new Role(ERole.ROLE_CUSTOMER);
    @RequestMapping("/")
    public String home(Model model,HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        request.getSession(true);
        model.addAttribute("user", currentUser);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "register";
    }

    @RequestMapping("/spiritdirectortable")
    public String spiritdirectortable(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        model.addAttribute("user", currentUser);
        return "spiritdirectortable";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        model.addAttribute("user", currentUser);return "dashboard";
    }

    @RequestMapping("/request")
    public String request(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        model.addAttribute("user", currentUser);return "request";
    }

    @RequestMapping("/tcuevent")
    public String tcuevent(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        model.addAttribute("user", currentUser);
        return "tcuevent";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/calendar")
    public String calendar(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        model.addAttribute("user", currentUser);return "calendar";
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
//        user.addRole(r1);
        userRepository.save(user);
        return "register_success";
    }

    @GetMapping("/access_denied")
    String accessDenied(){
        return "accessDenied";
    }

//    @RequestMapping("/success")
//    public String success() {
//        System.out.println(userRepository.findAll());
//        return "/";
//    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }

}
