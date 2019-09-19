import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The door to enter the Gym.
 * 
 * @author Clarence Su
 */
public class GymDoor extends Door
{    
    protected List <MainCharacter> p;
    /**
     * Act - do whatever the GymDoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //sets world to GymWorld        
        if (p == null){
            p = getObjectsInRange(600, MainCharacter.class);
        }
        if (this.isTouching(MainCharacter.class)){  
            Greenfoot.setWorld(new GymWorld(p.get(0)));  
        }  
    }    
}
