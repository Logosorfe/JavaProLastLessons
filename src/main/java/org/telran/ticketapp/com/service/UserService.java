package org.telran.ticketapp.com.service;

import org.telran.ticketapp.com.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    void deleteById(long id);

    User create(User user);

    User findById(long id);

    Optional<User> findByEmail(String email);
}
