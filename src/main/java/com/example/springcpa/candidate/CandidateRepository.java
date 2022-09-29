package com.example.springcpa.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    //return the candidate object (nullable) with that email 
    @Query("SELECT c FROM Candidate c WHERE c.email = ?1")
    Optional<Candidate> findCandidateByEmail(String email);

    //get all candidate without a cover_letter 
    @Query("SELECT c FROM Candidate c WHERE c.coverLetter = null")
    List<Candidate> findByCoverLetter();

    //get candidate with certain id 
    @Query("SELECT c FROM Candidate c WHERE c.id = :id")
    Optional<Candidate> findById(@Param("id") Long id);

}
