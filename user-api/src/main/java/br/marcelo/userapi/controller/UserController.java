package br.marcelo.userapi.controller;

import br.marcelo.userapi.model.User;
import br.marcelo.userapi.repository.UserRepository;
import br.marcelo.userapi.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/get/{user}")
    public User get(@PathVariable("user") User user) {
        return user;
    }

    @PutMapping("/update/")
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{user}")
    public boolean delete(@PathVariable("user") User user) {
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PreAuthorize(Constants.PERMISAO_ADMIN)
    @PostMapping("/update-password/{user}")
    public User updatePassword(@PathVariable("user") User user, @RequestBody String password) {
        user.setPassword(password);
        return userRepository.save(user);
    }

}
