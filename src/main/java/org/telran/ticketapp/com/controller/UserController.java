package org.telran.ticketapp.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.telran.ticketapp.com.dto.UserCreateDto;
import org.telran.ticketapp.com.dto.UserDto;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.security.AuthenticationService;
import org.telran.ticketapp.com.security.model.SignInRequest;
import org.telran.ticketapp.com.security.model.JwtAuthenticationResponse;
import org.telran.ticketapp.com.service.UserService;
import org.telran.ticketapp.com.service.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private Converter<User, UserDto, UserCreateDto> converter;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAll() {
        return service.getAll().stream()
                .map(user -> converter.toDto(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return converter.toDto(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @PostMapping
    public UserDto create(@RequestBody UserCreateDto userCreateDto) {
        User user = converter.toEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return converter.toDto(service.create(user));
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }
}
