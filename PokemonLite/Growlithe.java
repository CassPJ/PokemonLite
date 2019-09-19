import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Sets specific information for Growlithe
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Growlithe extends Pokemon
{
    
    public Growlithe(){
        super();
        Random r = new Random();                
        level = 5;
        hp = 15;        
        fullHp = 15;
        fullHp = 60;
        datafile = "Growlithe.txt";
        name = "Growlithe";
        setDamage();
        type = "Fire";
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
