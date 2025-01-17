package com.example.votaciones2.controllers;

import com.example.votaciones2.DTO.Request.AdminLogin;
import com.example.votaciones2.DTO.Request.VoterLogin;
import com.example.votaciones2.DTO.Response.AdminResponse;
import com.example.votaciones2.DTO.Response.VoterResponse;
import com.example.votaciones2.models.Admin;
import com.example.votaciones2.models.Voter;
import com.example.votaciones2.services.AdminService;
import com.example.votaciones2.services.EmailService;
import com.example.votaciones2.services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final VoterService voterService;
    private final AdminService adminService;
    private final EmailService emailService;

    @PostMapping("/voter")
    public ResponseEntity<VoterResponse> voterLogin(@RequestBody VoterLogin voterLogin){
        Voter voter = voterService.getVoterByCredentials(voterLogin.dni(), voterLogin.code());
        VoterResponse voterResponse = new VoterResponse(voter.getIdVoter(), voter.getName(), voter.getRole(), voter.getHasVoted());
        return ResponseEntity.ok(voterResponse);
    }

    @PostMapping("/admin")
    public ResponseEntity<AdminResponse> adminLogin(@RequestBody AdminLogin adminLogin){
        Admin admin = adminService.getAdminByCredentials(adminLogin.email(), adminLogin.password());
        AdminResponse adminResponse = new AdminResponse(admin.getIdAdmin(), admin.getEmail(), admin.getRole());
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/emails")
    public ResponseEntity<Void> sendEmails(){
        List<Voter> voters = voterService.getAllVoters();
        voters.forEach(voter -> emailService.sendCodeEmail(voter.getEmail(), voter.getCode()));
        return ResponseEntity.ok().build();
    }
}
