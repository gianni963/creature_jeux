package be.bxl.formation.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Affrontement {
    private Dresseur participant1;
    private Dresseur participant2;
    private int nbrTour = 4;

    public Dresseur getParticipant1() {
        return participant1;
    }

    public Dresseur getParticipant2() {
        return participant2;
    }

    public void setParticipant1(Dresseur participant1) {
        this.participant1 = participant1;
    }

    public void setParticipant2(Dresseur participant2) {
        this.participant2 = participant2;
    }

    public Affrontement(Dresseur participant1, Dresseur participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public void simulation() {
        int tourActuel = 0;

//        System.out.println("Simulation de la cours");
//        System.out.println();
        while(tourActuel < this.nbrTour) {
            tourActuel++;

            participant1.changerCreature();
            System.out.println(participant1.getNom() + " choisit " + participant1.getCreatureActuelle().getNom());
            participant2.changerCreature();
            System.out.println(participant2.getNom() + " choisit " + participant2.getCreatureActuelle().getNom());

            participant1.preparerEsquive(participant1.getCreatureActuelle());
            System.out.println(participant1.getNom() + " prepare une esquive avec " + participant1.getCreatureActuelle().getNom());
            participant2.preparerEsquive(participant2.getCreatureActuelle());
            System.out.println(participant2.getNom() + " prepare une esquive avec " + participant2.getCreatureActuelle().getNom());

            participant1.preparerProtection(participant1.getCreatureActuelle());
            System.out.println(participant1.getNom() + " prepare une protection avec " + participant1.getCreatureActuelle().getNom());
            participant2.preparerProtection(participant2.getCreatureActuelle());
            System.out.println(participant2.getNom() + " prepare une protection avec " + participant2.getCreatureActuelle().getNom());

            if(participant1.getCreatureActuelle().getVitesse() > participant1.getCreatureActuelle().getVitesse()){
                participant1.effectuerUneAttaque(participant2.getCreatureActuelle());
                participant2.effectuerUneAttaque(participant1.getCreatureActuelle());
            }else{
                participant2.effectuerUneAttaque(participant1.getCreatureActuelle());
                participant1.effectuerUneAttaque(participant2.getCreatureActuelle());

            }

        }
    }
}
