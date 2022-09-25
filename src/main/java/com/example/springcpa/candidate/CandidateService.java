package com.example.springcpa.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.*;
import java.util.*;


@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }
    public List<Candidate> getCandidates(){
        return candidateRepository.findAll();
    }

    public void addNewCandidate(Candidate candidate){
        Optional<Candidate> candidateEmailOptional = candidateRepository
                .findCandidateByEmail(candidate.getEmail());
        if (candidateEmailOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        candidateRepository.save(candidate);
    }

}
