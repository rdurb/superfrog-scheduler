package tcu.webtech.superfrogscheduler.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcu.webtech.superfrogscheduler.models.ERole;
import tcu.webtech.superfrogscheduler.models.Role;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.payload.request.LoginRequest;
import tcu.webtech.superfrogscheduler.payload.request.SignupRequest;
import tcu.webtech.superfrogscheduler.payload.response.JwtResponse;
import tcu.webtech.superfrogscheduler.payload.response.MessageResponse;
import tcu.webtech.superfrogscheduler.repositories.RoleRepository;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.security.jwt.AuthEntryPoint;
import tcu.webtech.superfrogscheduler.security.jwt.JwtUtils;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        logger.info("Logging in user with email: " + userDetails.getEmail());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(customerRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "superfrog":
                        Role superfrogRole = roleRepository.findByName(ERole.ROLE_SUPERFROG)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(superfrogRole);

                        break;
                    case "spiritdirector":
                        Role spiritDirectorRole = roleRepository.findByName(ERole.ROLE_SPIRITDIRECTOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(spiritDirectorRole);

                        break;
                    default:
                        Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(customerRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        logger.info("Registering user with email: " + user.getEmail());

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
