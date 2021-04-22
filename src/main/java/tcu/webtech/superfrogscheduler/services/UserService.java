package tcu.webtech.superfrogscheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateUserById(Long userID, String email, String firstName, String lastName) {
        User user = userRepository.getOne(userID);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
    }

    public void deactivate(Long userID) {

    }

    public void activate(Long userID) {

    }

}
