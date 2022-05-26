package com.ceca.vitrasaapispring;

import com.ceca.vitrasaapispring.modl.scrapper.Scrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.IOException;

@SpringBootApplication
public class VitrasaApIspringApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(VitrasaApIspringApplication.class, args);
        Scrapper scrapper = new Scrapper();
        scrapper.getExample();
    }

}
