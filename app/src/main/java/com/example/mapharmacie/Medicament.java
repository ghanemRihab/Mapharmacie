package com.example.mapharmacie;

public class Medicament {
    private int id;
    private String nom;
    private String dosage;
    private String frequence;
    private int nombresBoites;
    private String momentPrise;

    // Constructeur
    public Medicament(String nom, String dosage, String frequence, int nombresBoites, String momentPrise) {
        this.nom = nom;
        this.dosage = dosage;
        this.frequence = frequence;
        this.nombresBoites = nombresBoites;
        this.momentPrise = momentPrise;
    }

    public Medicament(int id, String nom, String dose, int nbPrise, String traitement, int quantite, String tempsPrise) {
    }

    // Getter et Setter pour l'ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter et Setter pour le nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour le dosage
    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    // Getter et Setter pour la fréquence
    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    // Getter et Setter pour le nombre de boîtes
    public int getNombresBoites() {
        return nombresBoites;
    }

    public void setNombresBoites(int nombresBoites) {
        this.nombresBoites = nombresBoites;
    }

    // Getter et Setter pour le moment de prise
    public String getMomentPrise() {
        return momentPrise;
    }

    public void setMomentPrise(String momentPrise) {
        this.momentPrise = momentPrise;
    }

    public String getDose() {
        return null;
    }
}

