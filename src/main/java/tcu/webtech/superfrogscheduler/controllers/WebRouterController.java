package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;
import tcu.webtech.superfrogscheduler.services.UserDetailsServiceImpl;

@Controller
public class WebRouterController {

    @Autowired
    private UserRepository userRepository;
    private UserDetailsServiceImpl customUserDetailsService;

    @RequestMapping("/")
    public String home(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("firstName", currentUser.getFirstName());
        model.addAttribute("lastName", currentUser.getLastName());
        return "index";
    }

//    @RequestMapping("/spiritdirectortable")
//    public String spiritdirectortable(Model model) {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails currentUser = ((UserDetailsImpl) authentication.getPrincipal());
//
//        model.addAttribute("user", currentUser);
//        return "spiritdirectortable";
//    }
//
//    @RequestMapping("/dashboard")
//    public String dashboard(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
//
//        model.addAttribute("user", currentUser);return "dashboard";
//    }
//
//    @RequestMapping("/request")
//    public String request(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
//
//        model.addAttribute("user", currentUser);return "request";
//    }
//
//    @RequestMapping("/tcuevent")
//    public String tcuevent(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
//
//        model.addAttribute("user", currentUser);
//        return "tcuevent";
//    }
//
//    @RequestMapping("/calendar")
//    public String calendar(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
//
//        model.addAttribute("user", currentUser);return "calendar";
//    }

    @GetMapping("/access_denied")
    String accessDenied(){
        return "accessDenied";
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
