package com.example.votaciones2.services;


import com.example.votaciones2.exceptions.ModelNotFoundException;
import com.example.votaciones2.models.Voter;
import com.example.votaciones2.repo.VoterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VoterService {

    private final VoterRepo voterRepo;

    public Voter getVoterByCredentials(String dni, String code){
        return voterRepo.getVoterByCredentials(dni, code).orElseThrow(() -> new ModelNotFoundException("DNI o código incorrecto"));
    }
}
