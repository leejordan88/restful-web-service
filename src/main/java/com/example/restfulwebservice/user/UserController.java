package com.example.restfulwebservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
        Optional<User> byId = userDaoService.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return byId.get();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        System.out.println(user);
        return userDaoService.save(user);
    }


}
