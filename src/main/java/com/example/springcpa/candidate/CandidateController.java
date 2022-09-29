package com.example.springcpa.candidate;

import java.util.*;

import javax.websocket.server.PathParam;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/candidate")//enter this path in the url to request from end point
public class CandidateController {

    private static final String REQUEST_BODY_NULL = "Request does not contain a body. Action can not be done.";
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
