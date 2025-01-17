package com.example.votaciones2.controllers;

import com.example.votaciones2.DTO.Request.UserVotation;
import com.example.votaciones2.DTO.Response.VoterResultResponse;
import com.example.votaciones2.models.Voter;
import com.example.votaciones2.services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/voter")
@RestController
public class VoterController {

    private final VoterService voterService;

    @PostMapping("/vote")
    public ResponseEntity<Void> votation(@RequestBody UserVotation userVotation){
        Voter voter = voterService.getVoterByIdVoter(userVotation.idVoter());
        voter.setIdList(userVotation.idList());
        voter.setHasVoted(true);
        voterService.saveVote(voter);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<VoterResultResponse>> findAll(){
        List<VoterResultResponse> voters = voterService
                .getAllVoters()
                .stream()
                .map(voter -> new VoterResultResponse(
                        voter.getName(),
                        voter.getDni(),
                        voter.getIdList(),
                        voter.getHasVoted()))
                .toList();
        return ResponseEntity.ok(voters);
    }
}
