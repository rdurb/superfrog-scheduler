package tcu.webtech.superfrogscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.EventStatus;
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
        // Create the users
        User customer1 = new User(
                "customer@gmail.com",
                passwordEncoder.encode("password"),
                "Riley",
                "Durbin",
                "222-222-2222",
                "CUSTOMER");

        User customer2 = new User(
                "customer2@gmail.com",
                passwordEncoder.encode("password"),
                "Cuong",
                "Nguyen",
                "444-444-4444",
                "CUSTOMER");

        User customer3 = new User(
                "customer3@gmail.com",
                passwordEncoder.encode("password"),
                "Kundan",
                "Chaundhary",
                "555-555-5555",
                "CUSTOMER");

        User superfrog = new User(
                "superfrog@gmail.com",
                passwordEncoder.encode("password"),
                "Bingyang",
                "Wei",
                "777-777-7777",
                "SUPERFROG");

        User superfrog2 = new User(
                "superfrog2@gmail.com",
                passwordEncoder.encode("password"),
                "Liran",
                "Ma",
                "888-888-8888",
                "SUPERFROG");

        User spiritdirector = new User(
                "spiritdirector@gmail.com",
                passwordEncoder.encode("password"),
                "Victor",
                "Boschini",
                "999-999-9999",
                "SPIRITDIRECTOR");

        // Save the users
        userRepository.save(customer1);
        userRepository.save(customer2);
        userRepository.save(customer3);

        userRepository.save(superfrog);
        userRepository.save(superfrog2);

        userRepository.save(spiritdirector);

        // Create the events
        Event event1 = new Event(
                "customer@gmail.com",
                "Event 1",
                "Event description",
                "2021-04-27",
                "12:00 PM",
                "1:00 PM");

        Event event2 = new Event(
                "customer2@gmail.com",
                "Event 2",
                "Event description",
                "2021-04-28",
                "12:00 PM",
                "1:00 PM");

        Event event3 = new Event(
                "customer3@gmail.com",
                "Event 3",
                "Event description",
                "2021-04-29",
                "12:00 PM",
                "1:00 PM");

        event3.setStatus(EventStatus.APPROVED);

        // Save the events
        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
    }
}