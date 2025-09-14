package com.emilsbyggservice.backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("!prod")
public class AdminSeeder implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder enc;


    @Override
    public void run(String... args) {
        String username = "admin@emilsbygg.se";
        if (!repo.existsByUsername(username)) {
            repo.save(User.builder()
                    .username(username)
                    .password(enc.encode("admin123"))
                    .role("ROLE_ADMIN")
                    .enabled(true).build());
        }
    }

}
