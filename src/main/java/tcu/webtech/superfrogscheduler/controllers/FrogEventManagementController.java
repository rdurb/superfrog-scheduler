package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.EventStatus;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.EventRepository;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FrogEventManagementController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/frogeventmanagement")
    public String eventManagement(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        // Get a list of all events that are approved but have not been assigned a SuperFrog yet
        List<Event> allAvailableEvents = eventRepository.findAllByStatus(EventStatus.APPROVED)
                .stream()
                .filter(event -> event.getAssignedSuperFrogEmail().equals(""))
                .collect(Collectors.toList());

        // Upcoming approved events that are assigned to the superfrog
        List<Event> myUpcomingEvents = eventRepository.findAllByStatus(EventStatus.APPROVED)
                .stream()
                .filter(event -> event.getAssignedSuperFrogEmail().equals(currentUser.getEmail()))
                .collect(Collectors.toList());

        // Get a list of all events that were completed by the current superfrog
        List<Event> allFinishedEvents = eventRepository.findAllByStatus(EventStatus.FINISHED)
                .stream()
                .filter(event -> event.getAssignedSuperFrogEmail().equals(currentUser.getEmail()))
                .collect(Collectors.toList());

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("editEvent", new Event());
        model.addAttribute("availableEvents", allAvailableEvents);
        model.addAttribute("upcomingEvents", myUpcomingEvents);
        model.addAttribute("finishedEvents", allFinishedEvents);

        return "frogeventmanagement";
    }

    @PostMapping("/frogeventmanagement/takeOwnership/{eventId}")
    public String approveEvent(@PathVariable("eventId") Long eventId, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        Event event = eventRepository.getOne(eventId);
        event.setAssignedSuperFrogEmail(currentUser.getEmail());

        eventRepository.save(event);

        return "redirect:/frogeventmanagement";
    }

    @RequestMapping("/frogeventmanagement/finish/{eventId}")
    public String finishEvent(@PathVariable("eventId") Long eventId) {
        Event eventToFinish = eventRepository.getOne(eventId);
        eventToFinish.setStatus(EventStatus.FINISHED);
        eventRepository.save(eventToFinish);

        return "redirect:/frogeventmanagement";
    }

}
