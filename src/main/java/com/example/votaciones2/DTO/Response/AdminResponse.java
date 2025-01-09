package com.example.votaciones2.DTO.Response;

public record AdminResponse(
        Integer idAdmin,
        String email,
        String role
) {
}
