package com.example.votaciones2.services;

import com.example.votaciones2.exceptions.ModelNotFoundException;
import com.example.votaciones2.models.Admin;
import com.example.votaciones2.repo.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;

    public Admin getAdminByCredentials(String email, String password){
        return adminRepo.getAdminByCredentials(email, password).orElseThrow(() -> new ModelNotFoundException("Correo o contraseña incorrectos"));
    }

}
