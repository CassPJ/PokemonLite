import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets specific information for Charmander
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Charmander extends Pokemon
{
    public Charmander(){
        super();
        level = 7;
        hp = 30;        
        fullHp = 30;
        datafile = "Charmander.txt";
        name = "Charmander";
        setDamage();
        type = "Fire";        
        species = "Charmander";
    }

    public Charmander(int lvl, String nom){
        super();
        level = lvl;
        hp = 30 + (5 * (lvl - 5));
        datafile = "Charmander.txt";
        name = nom;
        setDamage();
        type = "Fire";
        species = "Charmander";
    }

    /**
     * Act - do whatever the Rattata wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.      
        super.act();
    }      
}
