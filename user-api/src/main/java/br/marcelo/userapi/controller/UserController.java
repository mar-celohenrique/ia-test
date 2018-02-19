package br.marcelo.userapi.controller;

import br.marcelo.userapi.model.User;
import br.marcelo.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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

    @PostMapping("/update-password/{user}")
    public User updatePassword(@PathVariable("user") User user, @RequestBody String password) {
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

}
