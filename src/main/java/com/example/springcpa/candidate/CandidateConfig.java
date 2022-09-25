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

            Candidate alex = new Candidate("Alex",
                                            "Aiono",
                                        "alex.aino@gmail.com",
                                        LocalDate.of(2000, Month.APRIL, 1 ));
            Candidate ben = new Candidate("Ben",
                                            "Brook",
                                        "ben.brook@gmail.com",
                                        LocalDate.of(1997, Month.JULY, 12 ));

            candidateRepository.saveAll(//revoke our candidate repository
                    List.of(alex, ben)
            );
        };
    }
}
