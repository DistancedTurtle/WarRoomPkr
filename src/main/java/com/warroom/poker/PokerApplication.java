package com.warroom.poker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.warroom.poker")
@EnableJpaRepositories("com.warroom.poker.repository")
@EntityScan("com.warroom.poker.model")
public class PokerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokerApplication.class, args);
    }
}
