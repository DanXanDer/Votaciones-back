package com.example.votaciones2.services;

import com.example.votaciones2.models.CandidateList;
import com.example.votaciones2.repo.CandidateListRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CandidateListService {
    private final CandidateListRepo candidateListRepo;

    public List<CandidateList> getAllCandidateLists(){
        return candidateListRepo.findAll();
    }
}
