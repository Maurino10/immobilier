package com.bien.Immobilier.Controller;

import com.bien.Immobilier.Model.Client;
import com.bien.Immobilier.Model.Proprietaire;
import com.bien.Immobilier.Service.ClientService;
import com.bien.Immobilier.Service.ProprietaireService;
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

    @Autowired
    private ProprietaireService proprietaireService;

    @Autowired
    private ClientService clientService;
    
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
            return "redirect:/logproprietaire";
        }
        return "";
    }
    
    @GetMapping("/logproprietaire")
    public String ShowLogProprietaire() {
        return "Proprietaire/login";
    }
    
    
    @PostMapping("/logproprietaire")
    public String logProprietaire(Model model, HttpSession session, @RequestParam("nom") String nom) {
        Proprietaire proprietaire = proprietaireService.getUser(nom);
        if (proprietaire != null) {
            String token = tokenProvider.generateAccessToken(proprietaire);
            session.setAttribute("token", token);
            return "redirect:/proprietaire/biens";
        }
        return "";
    }
    
    @GetMapping("/logclient")
    public String ShowLogClient() {
        return "Client/login";
    }

    @PostMapping("/logclient")
    public String logClient(Model model, HttpSession session, @RequestParam("email") String email) {
        Client client = clientService.getUser(email);
        if (client != null) {
            String token = tokenProvider.generateAccessToken(client);
            session.setAttribute("token", token);
            return "redirect:/logproprietaire";
        }
        return "";
    }
}
