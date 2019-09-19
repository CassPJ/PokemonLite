import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This door spawns you in the PokeCentre.
 * 
 * @author Clarence Su
 */
public class CentreDoor extends Door
{
    protected List <MainCharacter> p;
    /**
     * Act - do whatever the CentreDoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (p == null){
            p = getObjectsInRange(600, MainCharacter.class);
        }
        if (this.isTouching(MainCharacter.class)){
            p.get(0).getPokemonOne().restoreHealth();
            Greenfoot.setWorld(new PokeCentreWorld(p.get(0), p.get(0).getPokemonOne()));  
        }  
    }    
}
