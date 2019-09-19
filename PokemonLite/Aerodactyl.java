import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets specific information for Aerodactyl
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Aerodactyl extends Pokemon
{
     public Aerodactyl(){
        super();
        level = 10;
        hp = 50;
        fullHp =50;
        datafile = "Aerodactyl.txt";
        name = "Aerodactyl";
        type = "Rock";
        typeTwo = "Flying";
        setDamage();
    }
    /**
     * Act - do whatever the Aerodactyl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
