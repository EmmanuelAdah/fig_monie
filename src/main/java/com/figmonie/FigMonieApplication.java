package com.figmonie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FigMonieApplication {

    public static void main(String[] args) {
        SpringApplication.run(FigMonieApplication.class, args);
    }

}
