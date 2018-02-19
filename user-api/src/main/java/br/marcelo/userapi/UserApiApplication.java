package br.marcelo.userapi;

import br.marcelo.userapi.model.User;
import br.marcelo.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApiApplication {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public CommandLineRunner setup(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setPassword(bCryptPasswordEncoder.encode("senha"));
            user.setName("Marcelo Henrique");
            user.setLogin("marcelo");
            user.setAdmin(true);
            user.setEmail("marcelo12tab@gmail.com");
            user.setCreatedDate(new Date(System.currentTimeMillis()));
            userRepository.save(user);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }
}
