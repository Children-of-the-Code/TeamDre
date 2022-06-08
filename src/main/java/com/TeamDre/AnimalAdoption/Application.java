package com.TeamDre.AnimalAdoption;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Application {
    public static void main (String[] args) {
        try {
            SpringApplication.run(Application.class);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
