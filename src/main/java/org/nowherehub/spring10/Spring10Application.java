package org.nowherehub.spring10;

import org.nowherehub.spring10.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Spring10Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring10Application.class, args);
    }
}
