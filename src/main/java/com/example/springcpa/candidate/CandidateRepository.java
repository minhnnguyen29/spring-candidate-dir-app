package com.example.springcpa.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

//    @Query("SELECT c FROM Candidate c WHERE c.email = ?1")
    Optional<Candidate> findCandidateByEmail(String email);
}
