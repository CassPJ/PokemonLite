import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class spawns you in the Labratory(not finished).
 * 
 */
public class LabDoor extends Door
{
    /**
     * Act - do whatever the LabDoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (this.isTouching(MainCharacter.class)){  
            Greenfoot.setWorld(new LabratoryWorld());  
        }  
    }    
}
