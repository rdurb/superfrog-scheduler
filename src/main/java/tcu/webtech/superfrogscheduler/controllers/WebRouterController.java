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

    @RequestMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @RequestMapping("/tcuevent")
    public String tcuevent(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("user", currentUser);
        return "tcuevent";
    }

    @GetMapping("/access_denied")
    public String accessDenied(){
        return "accessDenied";
    }

    @RequestMapping("/success")
    public String success() {
        System.out.println(userRepository.findAll());
        return "/";
    }

}
