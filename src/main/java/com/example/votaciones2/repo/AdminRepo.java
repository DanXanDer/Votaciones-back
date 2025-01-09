package com.example.votaciones2.repo;

import com.example.votaciones2.models.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends IGenericRepo<Admin, Integer> {

    @Query("SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password")
    Optional<Admin> getAdminByCredentials(String email, String password);
}
