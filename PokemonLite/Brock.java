import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The gym leader Brock; He differs from other NPC trainers because you have to go up and talk
 * to him in order to battle. Also, he has 3 pokemon.
 * 
 * @Cassidy Powell-Jones & Edwin Chung
 * @June 2015
 */
public class Brock extends Trainer
{
    private Pokemon pokemonThree;
    public Brock(){
        super();
        setArsenal();
        setName();
        name = "Gym Leader Brock";
    }

    /**
     * Act - do whatever the Brock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        super.act();
    }    

    /**
     * Sets the two pokemon by picking from two possible arsenals
     */
    public void setArsenal(){
        pokemonOne = new Onix();
        pokemonTwo = new Rhyhorn();
        pokemonThree = new Graveler();
        pokemonOne.act();
        pokemonTwo.act();
        pokemonThree.act();
    }

    /**
     * Sets the name by picking one of four
     * Also sets the phrase they will say to challenge the player
     */
    public void setName(){
        name = "brock";
        preText = "My pokemon rock! Sorry to smash your dreams in your first gym!";
    }
}
