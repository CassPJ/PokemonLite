import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Sets specific information for Butterfree
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Butterfree extends Pokemon
{
    public Butterfree(){
        super();
        Random r = new Random();
        level = 6;
        hp = 20;
        fullHp = 20;
        datafile = "Butterfree.txt";
        name = "Butterfree";
        type = "Poison";
        typeTwo = "Flying";
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
