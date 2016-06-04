package com.albpal.ggame.tests.controllers;

import org.testng.annotations.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.albpal.ggame.resources.Version;

@SpringBootApplication
public class VersionControllerTest implements CommandLineRunner {

    @Test
    public void getVersion0001()
    {
        SpringApplication.run(VersionControllerTest.class, args);
        RestTemplate restTemplate = new RestTemplate();
        Version version = restTemplate.getForObject("http://localhost:8080/version", Version.class);
        System.out.println(version.toString());
    }
}
