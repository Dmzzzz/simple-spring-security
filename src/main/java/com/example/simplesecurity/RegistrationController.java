package com.example.simplesecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private String registration() {
        return "registration";
    }

    @PostMapping
    public String registrationUser(RegistrationFormDTO registrationForm) {
        userRepository.save(registrationForm.toUser(passwordEncoder));

        return "rediret:/login";
    }

}
