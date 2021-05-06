package be.bxl.formation;

import be.bxl.formation.models.Affrontement;
import be.bxl.formation.models.Creature;
import be.bxl.formation.models.Dresseur;

public class Main {

    public static void main(String[] args) {

        Creature drako = new Creature(6,2,15,22,"Drako");
        Creature pika = new Creature(5,2,16,22,"Pika");

        Dresseur gaston = new Dresseur("Gaston");
        Dresseur sacha = new Dresseur("Sacha");

        gaston.addCreature(drako);
        sacha.addCreature(pika);

        Affrontement bataille1 = new Affrontement(gaston, sacha);

        bataille1.simulation();
    }
}
