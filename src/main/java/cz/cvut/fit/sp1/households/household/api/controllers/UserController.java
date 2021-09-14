package cz.cvut.fit.sp1.households.household.api.controllers;


import cz.cvut.fit.sp1.households.household.api.dto.LoginUserDTO;
import cz.cvut.fit.sp1.households.household.api.dto.RegisterUserDTO;
import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static cz.cvut.fit.sp1.households.household.security.JwtProvider.createJWT;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDTO user) {
        try {
            //String fullName, String email, String password, Integer userID, Integer age
            userService.registerUser(user.getName(), user.getEmail(), user.getPassword(), user.getAge());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUserDTO user) {
        try {
            boolean hasLoggedIn = userService.loginUser(user.getEmail(), user.getPassword());
            if (!hasLoggedIn) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity ent = userService.findByEmail(user.getEmail());

        return new ResponseEntity<>(
                "\"" + createJWT(ent, 1999191999) + "\"",
                HttpStatus.OK);
    }
}
