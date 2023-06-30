package com.promineotech.vacation_planner.service;

import com.promineotech.vacation_planner.model.User;
import com.promineotech.vacation_planner.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found."));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long userId, User newUserDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(newUserDetails.getUsername());
            user.setPassword(newUserDetails.getPassword());
            user.setEmail(newUserDetails.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new EntityNotFoundException("User with id " +userId + "not found."));
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found."));
        userRepository.delete(user);
    }
}
