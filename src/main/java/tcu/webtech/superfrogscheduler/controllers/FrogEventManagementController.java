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

        List<Event> allPendingEvents = eventRepository.findAllByStatus(EventStatus.PENDING);
        List<Event> allApprovedEvents = eventRepository.findAllByStatus(EventStatus.APPROVED);
        List<Event> allFinishedEvents = eventRepository.findAllByStatus(EventStatus.FINISHED);

        List<User> allActiveSuperFrogs = userRepository.findAllByRole("SUPERFROG")
                .stream()
                .filter(user -> user.getIsActive())
                .collect(Collectors.toList());

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("editEvent", new Event());
        model.addAttribute("activeSuperFrogs", allActiveSuperFrogs);
        model.addAttribute("pendingEvents", allPendingEvents);
        model.addAttribute("approvedEvents", allApprovedEvents);
        model.addAttribute("finishedEvents", allFinishedEvents);

        return "frogeventmanagement";
    }

    @RequestMapping("/frogeventmanagement/approve/{eventId}")
    public String approveEvent(@PathVariable("eventId") Long eventId) {
        Event eventToApprove = eventRepository.getOne(eventId);
        eventToApprove.setStatus(EventStatus.APPROVED);
        eventRepository.save(eventToApprove);

        return "redirect:/frogeventmanagement";
    }

    @RequestMapping("/frogeventmanagement/reject/{eventId}")
    public String rejectEvent(@PathVariable("eventId") Long eventId) {
        Event eventToReject = eventRepository.getOne(eventId);
        eventToReject.setStatus(EventStatus.DENIED);
        eventRepository.save(eventToReject);

        return "redirect:/frogeventmanagement";
    }

    @RequestMapping("/frogeventmanagement/finish/{eventId}")
    public String finishEvent(@PathVariable("eventId") Long eventId) {
        Event eventToFinish = eventRepository.getOne(eventId);
        eventToFinish.setStatus(EventStatus.FINISHED);
        eventRepository.save(eventToFinish);

        return "redirect:/frogeventmanagement";
    }

    @PostMapping("/frogeventmanagement/editEvent")
    public String editEvent(@ModelAttribute("editEvent") Event event) {
        Event updatedEvent = eventRepository.getOne(event.getId());
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setDescription(event.getDescription());
        updatedEvent.setDate(event.getDate());
        updatedEvent.setStartTime(event.getStartTime());
        updatedEvent.setEndTime(event.getEndTime());
        updatedEvent.setRequestingUserEmail(event.getRequestingUserEmail());

        eventRepository.save(updatedEvent);

        return "redirect:/frogeventmanagement";
    }

    @PostMapping("/frogeventmanagement/assign/{eventId}/{superfrogId}")
    public String assignSuperFrogToEvent(@PathVariable("eventId") Long eventId, @PathVariable("superfrogId") Long superfrogId) {
        Event event = eventRepository.getOne(eventId);
        User superfrog = userRepository.getOne(superfrogId);

        event.setAssignedSuperFrogEmail(superfrog.getEmail());

        eventRepository.save(event);

        return "redirect:/frogeventmanagement";
    }

}
