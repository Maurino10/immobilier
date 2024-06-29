package com.bien.Immobilier.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bien.Immobilier.Helper.TokenProvider;
import com.bien.Immobilier.Model.Admin;
import com.bien.Immobilier.Service.AdminService;

import jakarta.servlet.http.HttpSession;




@Controller
public class LoginController {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AdminService adminService;
    
    
    @GetMapping("/")
    public String ShowLogAdmin() {
        return "Admin/login";
    }
    
    @PostMapping("/logadmin")
    public String logAdmin(Model model, HttpSession session, @RequestParam("login") String login, @RequestParam("password") String password) {
        Admin admin = adminService.getUser(login, password);
        if (admin != null) {
            String token = tokenProvider.generateAccessToken(admin);
            session.setAttribute("token", token);
            return "redirect:/logClient";
        }
        return "";
    }
    
    @GetMapping("/logproprietaire")
    public String ShowLogProprietaire() {
        return "login";
    }
    
    
    @PostMapping("/logproprietaire")
    public String logProprietaire() {
        return "";
    }
    
    @GetMapping("/logClient")
    public String ShowLogClient() {
        return "Client/login";
    }
}
