package com.example.restfulwebservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return byId.get();
    }

    @PostMapping("/users")
    public User save(@RequestBody @Valid User user) {
        System.out.println(user);
        return userDaoService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public User delete(@PathVariable int id) {
        Optional<User> byId = userDaoService.deleteById(id);
        if (byId.isEmpty()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return byId.get();
    }


}
