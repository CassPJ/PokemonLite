import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * All the Pokemon information for Fisherman.
 * 
 * @author Cassidy Powell-Jones & Edwin Chung 
 */
public class Fisherman extends Trainer
{
    public Fisherman(){
        super();
        setArsenal();
        setName();
        type = "fish";
        checkRightWalls();
        checkLeftWalls();
    }

    /**
     * Act - do whatever the Fisherman wants to do. This method is called whenever
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
            pokemonOne = new Ekans();
            pokemonTwo = new Psyduck();
        }
        if (arsenal == 1){
            pokemonOne = new Poliwhirl();
            pokemonTwo = new Poliwhirl();
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
            first = "Phil";
            preText = "I've battled the seas and now I battle Pokemon!";
        }
        if(nom == 1){
            first = "Finn";
            preText = "I've battled the seas and now I battle Pokemon!";
        }
        if(nom == 2){
            first = "Rob";
            preText = "I've seen fish who look tougher than you!";
        }
        if(nom == 3){
            first = "Shaddock";
            preText = "Let's see if you can battle like a fisherman!";
        }
        name = "Fisherman " + first;
    }
}
