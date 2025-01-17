package com.example.votaciones2.services;


import com.example.votaciones2.exceptions.ModelNotFoundException;
import com.example.votaciones2.models.Voter;
import com.example.votaciones2.repo.VoterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VoterService {

    private final VoterRepo voterRepo;

    public Voter getVoterByCredentials(String dni, String code){
        return voterRepo.getVoterByCredentials(dni, code).orElseThrow(() -> new ModelNotFoundException("DNI o código incorrecto"));
    }

    public Voter getVoterByIdVoter(Integer idVoter){
        return voterRepo.getVoterByIdVoter(idVoter);
    }

    public List<Voter> getAllVoters(){
        return voterRepo.getAllVoters();
    }

    public void saveVote(Voter voter){
        voterRepo.save(voter);
    }
}
