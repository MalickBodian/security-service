package sn.groupeisi.gestionsecurite.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.gestionsecurite.domaine.Role;
import sn.groupeisi.gestionsecurite.domaine.User;
import sn.groupeisi.gestionsecurite.services.impl.AppUserService;

import java.util.List;

public class UserController {
    AppUserService appUserService;

    @GetMapping
    public List<User> getUsers() {
        return appUserService.getUsers();
    }

    @GetMapping("{name}")
    public Role getUser(@PathVariable("name") String name) {
        return appUserService.getUser(name);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return AppUserService.create(user);
    }

    @PutMapping("{name}")
    public Role updateUser(@PathVariable("name") String name, @RequestBody User user) {
        return AppUserService.updateUser(name, user);
    }

    @DeleteMapping("{name}")
    public void deleteUser(@PathVariable("name") String name) {
        appUserService.deleteUser(name);
    }
}
