package com.example.mapharmacie;

public class MedicamentModal {
    private int id;
    private String nom;
    private String dose;
    private int nbPrise;
    private String traitement;
    private int quantite;
    private String tempsPrise;

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
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }


    // Getter et Setter pour le nombre de prises
    public int getNbPrise() {
        return nbPrise;
    }

    public void setNbPrise(int nbPrise) {
        this.nbPrise = nbPrise;
    }

    // Getter et Setter pour le traitement
    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    // Getter et Setter pour le nombre de prises
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public String getTempsPrise() {
        return tempsPrise;
    }

    public void setTempsPrise(String tempsPrise) {
        this.tempsPrise = tempsPrise;
    }

    public MedicamentModal(String nom, String dose, int nbPrise, String traitement, int quantite, String tempsPrise) {
        this.nom = nom;
        this.dose = dose;
        this.nbPrise = nbPrise;
        this.traitement = traitement;
        this.quantite = quantite;
        this.tempsPrise = tempsPrise;
    }
}
