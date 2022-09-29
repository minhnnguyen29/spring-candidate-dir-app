package com.example.springcpa.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.transaction.Transactional;


@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired 
    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    //GET 
    //all candidates 
    public List<Candidate> getCandidates(){
        return (List<Candidate>) candidateRepository.findAll();
    }
    //candidates who are disqualified
    public List<Candidate> getCandidatesWithoutCoverLetter(){
        return (List<Candidate>) candidateRepository.findByCoverLetter(); 
    }
    //candidate with Id
    public Optional<Candidate> getCandidateWithId(Long candidateId){
        Optional<Candidate> candidateOptionalId = candidateRepository.findById(candidateId);
        if (!candidateOptionalId.isPresent())
        {
            throw new IllegalStateException("Candidate with id " + candidateId+ " does not exist.");
        }
        return candidateOptionalId;
    }

    //POST
    public void addNewCandidate(Candidate candidate){
        Optional<Candidate> candidateEmailOptional = candidateRepository
                .findCandidateByEmail(candidate.getEmail());
        if (candidateEmailOptional.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        candidateRepository.save(candidate);

//        Optional<Candidate> candidateDOBOptional = candidateRepository
//                .findCandidateByDOB(candidate.getDob());
//        if (candidateDOBOptional.isPresent()){
//            if (candidate.getAge() >= 25){
//                throw new IllegalStateException("Too old to be hired");
//            }
//        }
//        candidateRepository.save(candidate);
    }


    //Delete Candidate Logic 
    public void deleteCandidate(Long candidateId){
        
        //check if provided Id exists, if not, throw exception
        boolean candidateExists = candidateRepository.existsById(candidateId); 
        if (!candidateExists) {
            throw new IllegalStateException(
                "Candidate with id " + candidateId + " does not exists."
            );
        }
        
        candidateRepository.deleteById(candidateId); //delete student if Id exists 
    }

    //Update candidate's details logic 
    @Transactional //allow us to update using setters 
    public void updateCandidateDetails(Long candidateId, String firstName, String email){

        //retrieve candidate with id, if null throw Exception  
        Candidate candidate = candidateRepository.findById(candidateId)
            .orElseThrow( () -> new IllegalStateException(
                "Candidate with id " + candidateId + " does not exist. Please provide a correct id"
            ));

        System.out.println("user id exists: " + candidateId + " " + firstName + " " + email);
        //update if candidate with id exists
        if(firstName != null && firstName.length() > 0 &&
                    !candidate.getFirstName().equals(firstName)) {
            candidate.setFirstName(firstName);
        }
        if(email != null && email.length() > 0){
            candidate.setEmail(email);
        }
    }

}
