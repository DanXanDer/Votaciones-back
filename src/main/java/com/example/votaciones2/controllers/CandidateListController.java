package com.example.votaciones2.controllers;

import com.example.votaciones2.DTO.Response.VoterCandidateListResponse;
import com.example.votaciones2.services.CandidateListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/candidate-list")
@RestController
public class CandidateListController {

    private final CandidateListService candidateListService;

    @GetMapping("/voter")
    public ResponseEntity<List<VoterCandidateListResponse>> getVoterCandidateList(){
        List<VoterCandidateListResponse> voterCandidateList = candidateListService
                .getAllCandidateLists()
                .stream()
                .map(
                        candidateList -> new VoterCandidateListResponse(
                                candidateList.getIdCandidateList(),
                                candidateList.getName(),
                                candidateList.getCandidates()
                        )
                ).toList();

        return ResponseEntity.ok().body(voterCandidateList);
    }
}
