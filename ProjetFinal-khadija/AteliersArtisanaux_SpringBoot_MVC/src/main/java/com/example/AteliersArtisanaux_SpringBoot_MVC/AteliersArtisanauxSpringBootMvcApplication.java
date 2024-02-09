package com.example.AteliersArtisanaux_SpringBoot_MVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.AteliersArtisanaux_SpringBoot_MVC.models")
public class AteliersArtisanauxSpringBootMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AteliersArtisanauxSpringBootMvcApplication.class, args);
    }

}
