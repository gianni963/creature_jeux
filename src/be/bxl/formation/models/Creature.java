package be.bxl.formation.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Creature {
    private int force;
    private int armure;
    private int vitesse;
    private int pv;
    private boolean protege;
    private boolean esquive;
    private java.lang.String nom;

    public int getForce() {
        return force;
    }

    public int getArmure() {
        return armure;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getPv() {
        return pv;
    }

    public boolean isProtege() {
        return protege;
    }

    public boolean isEsquive() {
        return esquive;
    }

    public java.lang.String getNom() {
        return nom;
    }

    public void setForce(int force) {

        if(force < 1 || force > 10 ) {
            throw new IllegalArgumentException("La force doit être comprise entre 1 et 10 !!!");
        }
        this.force = force;
    }

    public void setArmure(int armure) {

        if(armure < 0 || armure > 10 ) {
            throw new IllegalArgumentException("L'armure doit être comprise entre 0 et 10 !!!");
        }
        this.armure = armure;
    }

    public void setVitesse(int vitesse) {

        if(vitesse < 1 || vitesse > 10 ) {
            throw new IllegalArgumentException("La vitesse doit être comprise entre 1 et 10 !!!");
        }
        this.vitesse = vitesse;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setProtege(boolean protege) {
        this.protege = protege;
    }

    public void setEsquive(boolean esquive) {
        this.esquive = esquive;
    }

    public void setNom(java.lang.String nom) {

        if(nom == null) {
            throw new IllegalArgumentException("Le nom d'une creature ne peut être null !!!");
        }
        this.nom = nom;
    }

    public Creature(int force, int armure, int vitesse, int pv, java.lang.String nom) {
        this.force = force;
        this.armure = armure;
        this.vitesse = vitesse;
        if(pv < 15 || pv > 30 ) {
            throw new IllegalArgumentException("Les pv doivent être compris entre 15 et 30 !!!");
        }
        this.pv = pv;
        this.nom = nom;
    }

    public void attaquer(Creature ennemi){

        boolean esquiveReussie = false;
        double tauxEsquive;

        if(ennemi.isEsquive()) {
            tauxEsquive = (ennemi.getVitesse() * 0.02) + 0.5;
        }else{
            tauxEsquive = ennemi.getVitesse() * 0.02;
        }

        if(Math.random() <= tauxEsquive){
            esquiveReussie = true;
        }

        if(esquiveReussie ==  false) {
            int critical = 1;
            int diminutionDegat = 1;

            if (Math.random() <= 0.05) {
                critical = 2;
            }
            if (ennemi.isProtege()) {
                diminutionDegat = 2;
            }
            int degatTotal = (this.getForce() * critical) / diminutionDegat;

            ennemi.setPv(ennemi.getPv() - (ennemi.getArmure() - degatTotal));
            System.out.println(ennemi.getNom() + " reçoit un coup de " + this.nom);
            System.out.println(ennemi.getNom() + " perd " + this.force + " de pv. Ses pv sont maintenant à " + ennemi.getPv());
        }
    }

    public void seProteger(){
        this.setArmure(10);
        this.setProtege(true);
    }

    public void esquiver(){
        this.setEsquive(true);
    }
}
