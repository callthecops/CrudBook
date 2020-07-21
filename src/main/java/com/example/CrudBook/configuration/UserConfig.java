package com.example.CrudBook.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Enable both compoenent and entity scan will enable us to scan for entities and all other component types together.
@Configuration
@ComponentScan(basePackages = "User")
@EntityScan(basePackages = "User")
public class UserConfig {
}
