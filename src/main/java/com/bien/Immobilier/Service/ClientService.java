package com.bien.Immobilier.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bien.Immobilier.Model.Client;
import com.bien.Immobilier.Repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepo;

    public Client getUser(String email) {
        Client client = clientRepo.findByEmail(email);
        if (client != null) {
            return client;
        }
        return null;
    }
}
