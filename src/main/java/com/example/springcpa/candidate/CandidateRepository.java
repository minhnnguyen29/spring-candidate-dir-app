package com.example.springcpa.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    //return the candidate object (nullable) with that email 
    @Query("SELECT c FROM Candidate c WHERE c.email = ?1")
    Optional<Candidate> findCandidateByEmail(String email);

    //return all candidates 
}
