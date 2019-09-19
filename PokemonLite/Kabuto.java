import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets specific information for Kabuto
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Kabuto extends Pokemon
{
    public Kabuto(){
        super();
        level = 10;
        hp = 55;        
        fullHp = 55;
        datafile = "Kabuto.txt";
        name = "Kabuto";
        setDamage();
        type = "Rock";
        typeTwo = "Water";
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
