package ru.example.studentapp.service;

import org.springframework.stereotype.Service;
import ru.example.studentapp.model.User;
import ru.example.studentapp.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) { this.repository = repository; }

    public boolean register(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) return false;
        if (repository.findByUsername(username).isPresent()) return false;
        User user = new User();
        user.setUsername(username.trim());
        user.setPassword(password);
        repository.save(user);
        return true;
    }

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        return repository.findByUsername(username.trim())
                .map(user -> user.getPassword().equals(password)).orElse(false);
    }
}
