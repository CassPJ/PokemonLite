import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Sets specific information for Ekans
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Ekans extends Pokemon
{
    public Ekans(){
        super();
        Random r = new Random();        
        level = 5;
        hp = 15;        
        fullHp = 15;
        datafile = "Ekans.txt";
        name = "Ekans";
        type = "Poison";
        setDamage();
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
