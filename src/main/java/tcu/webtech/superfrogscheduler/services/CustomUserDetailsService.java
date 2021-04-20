package tcu.webtech.superfrogscheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.models.Role;
import tcu.webtech.superfrogscheduler.models.ERole;
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void saveUser(User user)
    {
        System.out.println("User firstname: " + user.getFirstName());
        System.out.println("User lastname: " + user.getLastName());
        System.out.println("User email: " + user.getEmail());
        System.out.println("User password: " + user.getPassword());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
//        Role role1 = new Role(ERole.ROLE_CUSTOMER);
//        user.addRole(role1);
        userRepo.save(user);
    }
}