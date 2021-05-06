package be.bxl.formation.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dresseur {

    private java.lang.String nom;

    private ArrayList<Creature> creaturesEnPossession;

    private Creature creatureActuelle;
    private Creature creatureEnnemieActuelle;

    public List<Creature> getCreaturesEnPossession() {
        return Collections.unmodifiableList(creaturesEnPossession);
    }

    public Creature getCreatureActuelle() {
        return creatureActuelle;
    }

    public java.lang.String getNom() {
        return nom;
    }

    public void setNom(java.lang.String nom) {

        if(nom == null) {
            throw new IllegalArgumentException("Le nom d'un dresseur ne peut être null !!!");
        }
        this.nom = nom;
    }

    public void setCreatureActuelle(Creature creatureActuelle) {
        this.creatureActuelle = creatureActuelle;
    }

    public Dresseur(java.lang.String nom) {
        this.nom = nom;
        this.creaturesEnPossession = new ArrayList<>();
    }

    public void addCreature(Creature creature) {

        this.creaturesEnPossession.add(creature);
    }

    public void changerCreature(){
        Creature newChoix = this.getCreaturesEnPossession().get(0);
        this.setCreatureActuelle(newChoix);
    }
    public void preparerEsquive(Creature creatureActuelle){
        creatureActuelle = this.creatureActuelle;
        creatureActuelle.esquiver();
    }

    public void preparerProtection(Creature creatureActuelle){
        creatureActuelle = this.creatureActuelle;
        creatureActuelle.seProteger();
    }

    public void effectuerUneAttaque(Creature creatureActuelle){
        creatureActuelle = this.creatureActuelle;
        creatureActuelle.attaquer(creatureEnnemieActuelle);
    }
   public Creature choisirCreatureRandom(ArrayList<Creature> creaturesEnPossession)
    {
        //TO DO MATH RANDOM FUNCTION
        Random rand = new Random();
        return creaturesEnPossession.get(rand.nextInt(creaturesEnPossession.size()));

    }

}
