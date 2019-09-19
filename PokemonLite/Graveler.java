import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets specific information for Graveler
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Graveler extends Pokemon
{
    public Graveler(){
        super();
        level = 10;
        hp = 50;
        fullHp = 60;
        datafile = "Graveler.txt";
        name = "Graveler";
        type = "Rock";
        setDamage();
    }
    /**
     * Act - do whatever the Graveler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                super.act();
    }    
}
