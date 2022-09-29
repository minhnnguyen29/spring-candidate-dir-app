package com.example.springcpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.springcpa.candidate.CandidateRepository;

@SpringBootTest
class SpringCpaApplicationTests {

@Autowired 
private CandidateRepository candidateRepository; 

	@Test
	// @Sql({"Candidate.sql"})
	void contextLoads() {
		// assertEquals(200, candidateRepository.findAll().size());
	}

}
