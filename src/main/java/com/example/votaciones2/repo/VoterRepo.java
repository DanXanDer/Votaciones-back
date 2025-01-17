package com.example.votaciones2.repo;


import com.example.votaciones2.DTO.Response.VoterSendEmail;
import com.example.votaciones2.models.Voter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoterRepo extends IGenericRepo<Voter, Integer> {
    Voter getVoterByIdVoter(Integer idVoter);

    @Query("SELECT v FROM Voter v WHERE v.dni = :dni AND v.code = :code")
    Optional<Voter> getVoterByCredentials(String dni, String code);

    @Query("SELECT v FROM Voter v")
    List<Voter> getAllVoters();

}
