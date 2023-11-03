package com.seolandfriends.byeolbyeolcoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.seolandfriends.byeolbyeolcoffee.admin.command.domain.repository")
public class ByeolByeolCoffeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ByeolByeolCoffeeApplication.class, args);
    }

}