package com.bien.Immobilier.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bien.Immobilier.Model.Admin;
import com.bien.Immobilier.Repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepo;

    public Admin getUser(String login, String password) {
        Admin admin = adminRepo.findBylogin(login, password);
        if (admin != null) {
            return admin;
        }
        return null;
    }
}
