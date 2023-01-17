package sn.groupeisi.gestionsecurite.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.gestionsecurite.domaine.Role;
import sn.groupeisi.gestionsecurite.services.impl.AppRoleService;

import java.util.List;

@RestController
@RequestMapping("roles")
@AllArgsConstructor
public class RoleController {
    AppRoleService appRoleService;

    @GetMapping
    public List<Role> getRoles() {
        return appRoleService.getRoles();
    }

    @GetMapping("{name}")
    public Role getRole(@PathVariable("name") String name) {
        return appRoleService.getRole(name);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role) {
        return AppRoleService.createRole(role);
    }

    @PutMapping("{name}")
    public Role updateRole(@PathVariable("name") String name, @RequestBody Role role) {
        return AppRoleService.updateRole(name, role);
    }

    @DeleteMapping("{name}")
    public void deleteRole(@PathVariable("name") String name) {
        appRoleService.deleteRole(name);
    }

}
