package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.EventStatus;
import tcu.webtech.superfrogscheduler.repositories.EventRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

import java.util.List;

@Controller
public class CalendarController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/calendar")
    public String calendar(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        List<Event> allEvents = eventRepository.findAll();
        List<Event> allPendingEvents = eventRepository.findAllByStatus(EventStatus.PENDING);
        List<Event> allApprovedEvents = eventRepository.findAllByStatus(EventStatus.APPROVED);

        model.addAttribute("user", currentUser);
        model.addAttribute("allEvents", allEvents);
        model.addAttribute("allPendingEvents", allPendingEvents);
        model.addAttribute("allApprovedEvents", allApprovedEvents);
        return "calendar";
    }
}
