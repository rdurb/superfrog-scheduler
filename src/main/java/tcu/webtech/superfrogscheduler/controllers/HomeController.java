package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.EventStatus;
import tcu.webtech.superfrogscheduler.repositories.EventRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/")
    public String home(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        // A list of all upcoming approved events for the current user
        List<Event> myUpcomingEvents = eventRepository.findAllByRequestingUserEmail(currentUser.getEmail())
                .stream()
                .filter(event -> event.getStatus() == EventStatus.APPROVED)     // Event must be in approved status, not finished
                .filter(event -> event.getAssignedSuperFrogEmail() != "")       // Event must be assigned a SuperFrog
                .collect(Collectors.toList());

        model.addAttribute("user", currentUser);
        model.addAttribute("editEvent", new Event());
        model.addAttribute("myUpcomingEvents", myUpcomingEvents);
        return "index";
    }

    @PostMapping("/editEvent")
    public String editEvent(@ModelAttribute("editEvent") Event event, @RequestHeader(value = HttpHeaders.REFERER, required = false) final String referrer) {
        Event updatedEvent = eventRepository.getOne(event.getId());
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setDescription(event.getDescription());
        updatedEvent.setDate(event.getDate());
        updatedEvent.setStartTime(event.getStartTime());
        updatedEvent.setEndTime(event.getEndTime());

        eventRepository.save(updatedEvent);

        return "redirect:" + referrer;
    }

}
