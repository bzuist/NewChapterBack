package dev.vorstu;

import dev.vorstu.repositories.AuthUserRepo;
import dev.vorstu.db.repositories.entities.auth.AuthUserEntity;
import dev.vorstu.db.repositories.entities.auth.BaseRole;
import dev.vorstu.db.repositories.entities.auth.RoleUserEntity;
import dev.vorstu.repositories.FanficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Initializer {

    @Autowired
    private FanficRepository fanficRepository;
    @Autowired
    private AuthUserRepo authUserRepo;

    public void initial() {

        AuthUserEntity admin = new AuthUserEntity(true, "admin", "1234",
                Collections.singleton(new RoleUserEntity("admin", BaseRole.SUPER_USER))
        );

        authUserRepo.save(admin);

        AuthUserEntity author = new AuthUserEntity(true, "author", "123456",
                Collections.singleton(new RoleUserEntity("author", BaseRole.AUTHOR))
        );

        authUserRepo.save(author);


    }
}

