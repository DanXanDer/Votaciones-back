package com.example.votaciones2.DTO.Response;

public record VoterResultResponse(
        String name,
        String dni,
        Integer idList,
        Boolean hasVoted
) {
}
