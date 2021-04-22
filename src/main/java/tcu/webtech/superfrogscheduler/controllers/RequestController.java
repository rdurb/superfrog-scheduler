package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

@Controller
public class RequestController {

    @RequestMapping("/request")
    public String request(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        model.addAttribute("user", currentUser);
        return "request";
    }

}
