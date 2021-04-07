package tcu.webtech.superfrogscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tcu.webtech.superfrogscheduler.models.ERole;
import tcu.webtech.superfrogscheduler.models.Role;
import tcu.webtech.superfrogscheduler.repositories.RoleRepository;

@Component
public class DBDataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        // We must initialize the roles in the DB for them to be recognized by login/signup
        Role r1 = new Role(ERole.ROLE_CUSTOMER);
        Role r2 = new Role(ERole.ROLE_SUPERFROG);
        Role r3 = new Role(ERole.ROLE_SPIRITDIRECTOR);

        roleRepository.save(r1);
        roleRepository.save(r2);
        roleRepository.save(r3);
    }
}
