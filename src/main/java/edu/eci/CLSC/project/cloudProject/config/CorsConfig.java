package edu.eci.CLSC.project.cloudProject.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.config.CorsRegistry;

import org.springframework.web.reactive.config.WebFluxConfigurer;


@Configuration

public class CorsConfig implements WebFluxConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://mango-cliff-0bb80e60f.5.azurestaticapps.net")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
