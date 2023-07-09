package com.promineotech.vacation_planner.controller;

import com.promineotech.vacation_planner.model.User;
import com.promineotech.vacation_planner.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController indicates that this class will be serving HTTP endpoints.
// @RequestMapping("/users") sets the base URI for all the endpoints in this controller.
// @Validated annotation ensures the methods in this class will be wrapped with a validator to validate the parameters.
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    // Reference to UserService, where all the business logic for user operations resides.
    private final UserService userService;

    // Constructor based dependency injection of UserService.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to retrieve all users.
    // @GetMapping is a shorthand for @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to retrieve a user by id.
    // @PathVariable indicates that a method parameter should be bound to a URI template variable
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Endpoint to create a new user.
    // @ResponseStatus(HttpStatus.CREATED) indicates that the response should have the HTTP status code 201 Created.
    // @RequestBody indicates a method parameter should be bound to the body of the web request.
    // @Valid indicates that the annotated element must be validated.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    // Endpoint to update a user.
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // Endpoint to delete a user.
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
