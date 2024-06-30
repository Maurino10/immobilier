package com.bien.Immobilier.Service;

import com.bien.Immobilier.Model.Bien;
import com.bien.Immobilier.Repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    public List<Bien> getAll (String idProprietaire) {
        List<Bien> biens = bienRepository.findAllProprietaire(idProprietaire);
        return biens;

    }
}
