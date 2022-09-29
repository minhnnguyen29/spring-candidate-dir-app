package com.example.springcpa.candidate;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/candidate")//enter this path in the url to request from end point
public class CandidateController {

    private final CandidateService candidateService;//access to Service Layer so logics can be performed in API


    @Autowired//allow Service.candidateService to be autowired & injected
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;//this will instantiate this.candidateService
    }

    //endpoint
    @GetMapping(path = "all")
    public List<Candidate> getCandidates(){
        return (List<Candidate>) candidateService.getCandidates();
    }

    @GetMapping(path = "disqualified")
    public List<Candidate> getCandidatesWithoutCoverLetter(){
        return (List<Candidate>) candidateService.getCandidatesWithoutCoverLetter();
    }

    //map user with certain id 
    @GetMapping(path = "{candidateId}")
    public Optional<Candidate> getCandidateWithId(@PathVariable("candidateId") Long candidateId){
        candidateService.getCandidateWithId(candidateId)
                .ifPresent(candidate -> candidate.printCandidate());;
        return candidateService.getCandidateWithId(candidateId);
    }


    @PostMapping
    public void registerNewCandidate(@RequestBody Candidate candidate){//take the payload from the client-side
        if(candidate != null){
            candidateService.addNewCandidate(candidate);
        }
    }


    @DeleteMapping(path = "{candidateId}")
    public void deleteCandidate(@PathVariable("candidateId") Long candidateId){
        candidateService.deleteCandidate(candidateId);
    }

    @PutMapping(path = "{candidateId}")
    public void updateCandidate(
        @PathVariable("candidateId") Long candidateId, 
        @RequestParam(required = false) String firstName, 
        @RequestParam(required = false) String email){
            candidateService.updateCandidateDetails(candidateId, firstName, email); 
    } 


}
