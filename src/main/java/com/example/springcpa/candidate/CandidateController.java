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
    @GetMapping
    public List<Candidate> getCandidates(){
        return candidateService.getCandidates();
    }

    @PostMapping
    public void registerNewCandidate(@RequestBody Candidate candidate){//take the payload from the client-side
        candidateService.addNewCandidate(candidate);
    }

}
