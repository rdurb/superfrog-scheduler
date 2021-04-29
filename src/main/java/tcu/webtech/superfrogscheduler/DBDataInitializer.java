package tcu.webtech.superfrogscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.EventRepository;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;

@Component
public class DBDataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadDefaultData();
    }

    public void loadDefaultData() {
        User customer = new User(
                "customer@gmail.com",
                passwordEncoder.encode("password"),
                "Sample",
                "Customer",
                "555-555-5555",
                "CUSTOMER");

        User superfrog = new User(
                "superfrog@gmail.com",
                passwordEncoder.encode("password"),
                "Sample",
                "Superfrog",
                "555-555-5555",
                "SUPERFROG");

        User superfrog2 = new User(
                "superfrog2@gmail.com",
                passwordEncoder.encode("password"),
                "Another",
                "SuperFrog",
                "555-555-5555",
                "SUPERFROG");

        User spiritdirector = new User(
                "spiritdirector@gmail.com",
                passwordEncoder.encode("password"),
                "Sample",
                "SpiritDirector",
                "555-555-5555",
                "SPIRITDIRECTOR");

        // Save the users
        userRepository.save(customer);
        userRepository.save(superfrog);
        userRepository.save(superfrog2);
        userRepository.save(spiritdirector);

        Event event1 = new Event(
                "riley.durbin@tcu.edu",
                "Event 1",
                "Event description",
                "2021-04-27",
                "12:00 PM",
                "1:00 PM");

        Event event2 = new Event(
                "riley.durbin@tcu.edu",
                "Event 2",
                "Event description",
                "2021-04-28",
                "12:00 PM",
                "1:00 PM");

        Event event3 = new Event(
                "riley.durbin@tcu.edu",
                "Event 3",
                "Event description",
                "2021-04-29",
                "12:00 PM",
                "1:00 PM");

        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
    }
}