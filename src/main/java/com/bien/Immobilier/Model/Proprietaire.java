package com.bien.Immobilier.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "proprietaire")
public class Proprietaire {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String id;

    private String nom;

    @Column(name = "tel")
    private int numero;

    public Proprietaire() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
}
