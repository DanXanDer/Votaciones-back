package com.example.votaciones2.DTO.Response;

public record VoterResponse(
        Integer idVoter,
        String fullname,
        String role
) {
}
