package com.example.lastproject.config;

import com.example.lastproject.DTO.FilmDTO;
import com.example.lastproject.service.FilmFilters;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Autowired
    public ValueKey mainConf;


    @Bean
    public FilmFilters filmFilters() {
        return new FilmFilters();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FilmDTO filmDTO() {
        return new FilmDTO();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpEntity<String> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(mainConf.getNameConf(), mainConf.getTokenConf());
        return new HttpEntity<>(httpHeaders);
    }
}
