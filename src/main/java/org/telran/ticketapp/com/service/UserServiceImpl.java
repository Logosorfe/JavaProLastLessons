package org.telran.ticketapp.com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.exception.EmailNotUniqueException;
import org.telran.ticketapp.com.exception.UserNotFoundException;
import org.telran.ticketapp.com.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository repository;

//    @Autowired
//    private TravelTicketService ticketService;

    @Override
    public List<User> getAll() {
        List<User> all = repository.findAll();
        log.info("All Users : {}", all);
        return all;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public User create(User user) {
        Optional<User> userFromDb = findByEmail(user.getEmail());
        if (userFromDb.isPresent()) {
            throw new EmailNotUniqueException("User with email " + user.getEmail() + " already exists");
        }
        return repository.save(user);
    }

    @Override
    public User findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
