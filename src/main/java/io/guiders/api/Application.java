package io.guiders.api;

import io.guiders.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner insertDB(UserRepository userRepository) {
        return args -> {
            /*Guider guider = new Guider();
            guider.setName("test");
            guider.setEmail("test@test.com");

            memberRepository.save(guider);*/
        };
    }

}
