package dev.vorstu.Controllers;

import dev.vorstu.repositories.AuthUserRepo;
import dev.vorstu.db.repositories.entities.auth.BaseRole;
import dev.vorstu.dto.ShortUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/home")

public class HomeController {
    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public Set<ShortUser> getAllUsers() {
        return authUserRepo.findAll().stream()
                .filter(el -> el.getRoles().stream().anyMatch(role ->
                        role.getRole().equals(BaseRole.AUTHOR)))
                .map(el -> new ShortUser(el.getId(), el.getUsername()))
                .collect(Collectors.toSet());
    }
}
