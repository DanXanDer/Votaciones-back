package com.example.votaciones2.controllers;

import com.example.votaciones2.DTO.Request.AdminRequest;
import com.example.votaciones2.DTO.Request.VoterRequest;
import com.example.votaciones2.DTO.Response.AdminResponse;
import com.example.votaciones2.DTO.Response.VoterResponse;
import com.example.votaciones2.models.Admin;
import com.example.votaciones2.models.Voter;
import com.example.votaciones2.services.AdminService;
import com.example.votaciones2.services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final VoterService voterService;
    private final AdminService adminService;

    @PostMapping("/voter")
    public ResponseEntity<VoterResponse> voterLogin(@RequestBody VoterRequest voterRequest){
        Voter voter = voterService.getVoterByCredentials(voterRequest.dni(), voterRequest.code());
        VoterResponse voterResponse = new VoterResponse(voter.getIdVoter(), voter.getName() + " " + voter.getLastname(), voter.getRole());
        return ResponseEntity.ok(voterResponse);
    }

    @PostMapping("/admin")
    public ResponseEntity<AdminResponse> adminLogin(@RequestBody AdminRequest adminRequest){
        Admin admin = adminService.getAdminByCredentials(adminRequest.email(), adminRequest.password());
        AdminResponse adminResponse = new AdminResponse(admin.getIdAdmin(), admin.getEmail(), admin.getRole());
        return ResponseEntity.ok(adminResponse);
    }

}
