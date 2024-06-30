package com.bien.Immobilier.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proprietaire")
public class Proprietaire {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "tel")
    private String numero;

    public Proprietaire() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    
}
