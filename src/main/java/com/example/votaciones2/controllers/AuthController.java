package com.example.votaciones2.controllers;

import com.example.votaciones2.DTO.Request.VoterRequest;
import com.example.votaciones2.DTO.Response.VoterResponse;
import com.example.votaciones2.models.Voter;
import com.example.votaciones2.services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final VoterService voterService;

    @PostMapping("/voter")
    public ResponseEntity<VoterResponse> voterLogin(@RequestBody VoterRequest voterRequest){
        Voter voter = voterService.getVoterByCredentials(voterRequest.dni(), voterRequest.code());
        VoterResponse voterResponse = new VoterResponse(voter.getIdVoter(), voter.getName() + " " + voter.getLastname(), voter.getRole());
        return ResponseEntity.ok(voterResponse);
    }

}
