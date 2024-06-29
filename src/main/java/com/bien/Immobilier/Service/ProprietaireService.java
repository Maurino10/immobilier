package com.bien.Immobilier.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bien.Immobilier.Model.Proprietaire;
import com.bien.Immobilier.Repository.ProprietaireRepository;

@Service
public class ProprietaireService {

    @Autowired
    private ProprietaireRepository proprietaireRepo;

    public Proprietaire getUser(String numero) {
        Proprietaire prop = proprietaireRepo.findByNumero(numero);
        if (prop != null) {
            return prop;
        }
        return null;
    }
}
