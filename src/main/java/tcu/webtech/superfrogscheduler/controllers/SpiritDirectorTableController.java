package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<User> allSuperFrogs = userRepository.findAllByRole("SUPERFROG");

        model.addAttribute("user", currentUser);
        model.addAttribute("customers", allCustomers);
        model.addAttribute("superfrogs", allSuperFrogs);
        return "spiritdirectortable";
    }

    @PostMapping("/spiritdirectortable/addCustomer")
    public String addCustomer() {
        return "";
    }

    @PostMapping("/spiritdirectortable/addSuperFrog")
    public String addSuperFrog() {
        return "";
    }

}
