import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets specific information for Bulbasaur
 * 
 * @Cassidy Powell-Jones
 * @June 2015
 */
public class Bulbasaur extends Pokemon
{
      public Bulbasaur(){
        super();
        level = 7;
        hp = 30;
        fullHp = 30;
        datafile = "Bulbasaur.txt";
        name = "Bulbasuar";
        setDamage();
        type = "Grass";
        typeTwo = "Poison";
        species = "Bulbasaur";
     }

    public Bulbasaur(int lvl, String nom){
        super();
        level = lvl;
        hp = 30 + (5 * (lvl - 5));
        datafile = "Bulbasaur.txt";
        setDamage();
        type = "Grass";
        typeTwo = "Poison";
        name = nom;
        species = "Bulbasaur";
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
