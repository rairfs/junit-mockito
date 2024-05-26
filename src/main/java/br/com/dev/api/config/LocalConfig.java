package br.com.dev.api.config;

import br.com.dev.api.domain.User;
import br.com.dev.api.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    private final UserRepository userRepository;

    public LocalConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void startDB(){
        User u1 = new User(null, "Rai", "rai@email.com", "123");
        User u2 = new User(null, "Valdir", "valdir@email.com", "123");

        userRepository.saveAll(List.of(u1, u2));
    }
}
