package org.telran.ticketapp.com.security;


import org.telran.ticketapp.com.security.model.JwtAuthenticationResponse;
import org.telran.ticketapp.com.security.model.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse authenticate(SignInRequest request);
}
