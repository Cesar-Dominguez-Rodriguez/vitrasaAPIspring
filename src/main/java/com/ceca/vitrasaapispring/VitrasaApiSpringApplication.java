package com.ceca.vitrasaapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class VitrasaApiSpringApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(VitrasaApiSpringApplication.class);
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(VitrasaApiSpringApplication.class, args);
    }

}
