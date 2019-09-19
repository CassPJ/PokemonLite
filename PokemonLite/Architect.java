import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * All the Pokemon information for Architect and also the text information.
 * 
 * @author Cassidy Powell-Jones & Edwin Chung 
 */
public class Architect extends Trainer
{
    public Architect(){
        super();
        setArsenal();
        setName();
        type = "arch";
    }

    /**
     * Act - do whatever the Architect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        super.act();
        // Add your action code here.
    }    

    /**
     * Sets the two pokemon by picking from two possible arsenals
     */
    public void setArsenal(){
        Random r = new Random();
        int arsenal = r.nextInt(1);
        if (arsenal == 0){
            pokemonOne = new Lunatone();
            pokemonTwo = new Kabuto();
        }
        if (arsenal == 1){
            pokemonOne = new Aerodactyl();
            pokemonTwo = new Rhydon();
        }
        pokemonOne.act();
        pokemonTwo.act();
    }

    /**
     * Sets the name by picking one of four
     * Also sets the phrase they will say to challenge the player
     */
    public void setName(){
        Random r = new Random();
        int nom = r.nextInt(4);
        String first = "";
        if(nom == 0){
            first = "Rocky";
            preText = "Pokemon are the building blocks of life!";
        }
        if(nom == 1){
            first = "Pierre";
            preText = "It takes hard work to become a Pokemon master!";
        }
        if(nom == 2){
            first = "Petra";
            preText = "My pokemon are my rocks!";
        }
        if(nom == 3){
            first = "Sansa";
            preText = "Let's see how you've built up your arsenal!";
        }
        name = "Architect " + first;
    }
}
