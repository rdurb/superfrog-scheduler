package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.EventRepository;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

@Controller
public class RequestController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasAnyAuthority('CUSTOMER', 'SUPERFROG', 'SPIRITDIRECTOR')")
    @RequestMapping("/request")
    public String request(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
        Event newRequest = new Event();

        model.addAttribute("user", currentUser);
        model.addAttribute("event", newRequest);
        return "request";
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER', 'SUPERFROG', 'SPIRITDIRECTOR')")
    @PostMapping("/request/process")
    public String processRequest(Model model, Authentication authentication, Event newRequest) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
        User currentUserObj = userRepository.findByEmail(currentUser.getEmail());

        Event event = new Event(
                currentUserObj.getEmail(),
                newRequest.getTitle(),
                newRequest.getDescription(),
                newRequest.getDate(),
                newRequest.getStartTime(),
                newRequest.getEndTime()
        );

        eventRepository.save(event);

        // TODO: notify user by email that their event has successfully been requested

        return "redirect:/calendar";
    }

}
