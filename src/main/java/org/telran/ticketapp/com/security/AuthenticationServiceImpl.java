package org.telran.ticketapp.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.security.model.JwtAuthenticationResponse;
import org.telran.ticketapp.com.security.model.SignInRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Override
    public JwtAuthenticationResponse authenticate(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(),
                request.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(request.getLogin());
        String token = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(token);
    }
}
