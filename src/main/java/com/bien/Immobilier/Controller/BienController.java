package com.bien.Immobilier.Controller;

import com.bien.Immobilier.Helper.Auth;
import com.bien.Immobilier.Helper.TokenProvider;
import com.bien.Immobilier.Model.Bien;
import com.bien.Immobilier.Model.Proprietaire;
import com.bien.Immobilier.Service.BienService;
import com.bien.Immobilier.Service.ProprietaireService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BienController {

    @Autowired
    private ProprietaireService proprietaireService;

    @Autowired
    private Auth auth;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private BienService bienService;

    @GetMapping("/proprietaire/biens")
    public String getAllBien(Model model, HttpSession session) {
        if (auth.authenticateProprietaire(session) == "present") {
            String token = (String) session.getAttribute("token");
            String numero = tokenProvider.validateToken(token);
            Proprietaire proprietaire = proprietaireService.getUser(numero);
            List<Bien> biens = bienService.getAll(proprietaire.getId());
            model.addAttribute("listeBien", biens);
            return "Proprietaire/listesBien";
        }
        return "";
    }

}
