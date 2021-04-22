package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

import java.util.List;

@Controller
public class SpiritDirectorTableController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasAuthority('SPIRITDIRECTOR')")
    @RequestMapping("/spiritdirectortable")
    public String spiritdirectortable(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
        List<User> allCustomers = userRepository.findAllByRole("CUSTOMER");

        model.addAttribute("customers", allCustomers);
        model.addAttribute("user", currentUser);
        return "spiritdirectortable";
    }

}
