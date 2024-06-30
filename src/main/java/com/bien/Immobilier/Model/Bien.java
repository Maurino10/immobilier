package com.bien.Immobilier.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bien")
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nom;
    private String description;
    private double loyer;
    @Column(name = "id_proprietaire")
    private String idProprietaire;
    @Column(name = "id_region")
    private String idRegion;
    @Column(name = "id_type_de_bien")
    private String idTypeDeBien;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }

    public String getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(String idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    public String getIdTypeDeBien() {
        return idTypeDeBien;
    }

    public void setIdTypeDeBien(String idTypeDeBien) {
        this.idTypeDeBien = idTypeDeBien;
    }
}
