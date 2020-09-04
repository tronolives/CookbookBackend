package com.cookbook.v001.Controllers;

import com.cookbook.v001.Entities.User;
import com.cookbook.v001.Security.DTO.AuthenticationRequest;
import com.cookbook.v001.Security.DTO.AuthenticationResponse;
import com.cookbook.v001.Security.DTO.RegistrationRequest;
import com.cookbook.v001.Security.Util.JwtUtil;
import com.cookbook.v001.Services.UserDetailsService;
import com.cookbook.v001.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;

    private UserService userService;

    private JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
                                    UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public AuthenticationController(){
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse(""));
        }

        final User user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewUser(@RequestBody RegistrationRequest registrationRequest) {

        if(!userService.userExists(registrationRequest.getUsername())){
            User newUser = new User();
            newUser.setEmail(registrationRequest.getEmail());
            newUser.setUsername(registrationRequest.getUsername());
            newUser.setPassword(registrationRequest.getPassword());
            userService.saveUser(newUser);
            return ResponseEntity.ok("some success");
        }
        return ResponseEntity.ok("some failure");
    }

}
