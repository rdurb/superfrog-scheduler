package tcu.webtech.superfrogscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;

@Component
public class DBDataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(
                "customer@gmail.com",
                passwordEncoder.encode("password"),
                "Sample",
                "Customer",
                "CUSTOMER")
        );

        userRepository.save(new User(
                "superfrog@gmail.com",
                passwordEncoder.encode("password"),
                "Sample",
                "Superfrog",
                "SUPERFROG")
        );

        userRepository.save(new User(
                "spiritdirector@gmail.com",
                passwordEncoder.encode("password"),
                "Sample",
                "SpiritDirector",
                "SPIRITDIRECTOR")
        );
    }
}