package com.bien.Immobilier.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bien.Immobilier.Model.Admin;
import com.bien.Immobilier.Model.Client;
import com.bien.Immobilier.Model.Proprietaire;
import com.bien.Immobilier.Repository.AdminRepository;
import com.bien.Immobilier.Repository.ClientRepository;
import com.bien.Immobilier.Service.AdminService;
import com.bien.Immobilier.Service.ClientService;
import com.bien.Immobilier.Service.ProprietaireService;

import jakarta.servlet.http.HttpSession;

@Service
public class Auth {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProprietaireService proprietaireService;

    @Autowired
    private ClientService clientService;


    public String authenticateAdmin(HttpSession session) {
        String role = "";
        String token = (String) session.getAttribute("token");
        if (token != null) {
            String subject = tokenProvider.validateToken(token);
            String login = Helper.getLoginAndPassword(subject)[0];
            String password = Helper.getLoginAndPassword(subject)[1];
            Admin admin = adminService.getUser(login, password);

            role = admin != null ? "present" : "";
        }
        return role;
    }

    public String authenticateProprietaire(HttpSession session) {
        String present = "";
        String token = (String) session.getAttribute("token");
        if (token != null) {
            String numero = tokenProvider.validateToken(token);
            Proprietaire client = proprietaireService.getUser(numero);
            present = client != null ? "present" : "";
        }
        return present;
    }

    public String authenticateClient(HttpSession session) {
        String present = "";
        String token = (String) session.getAttribute("token");
        if (token != null) {
            String email = tokenProvider.validateToken(token);
            Client client = clientService.getUser(email);
            present = client != null ? "present" : "";
        }
        return present;
    }
}
