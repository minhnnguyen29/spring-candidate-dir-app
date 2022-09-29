package com.example.springcpa.candidate;

import java.time.*;
import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CandidateConfig {

    @Bean
    CommandLineRunner commandLineRunner(CandidateRepository candidateRepository){
        return args -> {
            

                    };
    }
}
