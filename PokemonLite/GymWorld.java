import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * In this world, there are two mini-bosses and the final boss, Brock.
 * This is where the trainer goes to complete the game. 
 * The game is completed when the boss, Brock, is defeated.
 * 
 * @author Clarence Su 
 */
public class GymWorld extends ScrollingWorld
{
    MainCharacter mainCharacter;
    /**
     * Constructor for objects of class GymWorld.
     * 
     */
    public GymWorld(MainCharacter m)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(178, 320, 1);  

        setScrollingBackground(new GreenfootImage("Gym.png"));

        Mat mat = new Mat();
        addObject(mat, 190, 355);

        Tree tree = new Tree();
        addObject(tree, 165, 295);
        Tree tree2 = new Tree();
        addObject(tree2, 135, 295);
        Tree tree3 = new Tree();
        addObject(tree3, 105, 295);
        Tree tree4 = new Tree();
        addObject(tree4, 210, 295);
        Tree tree5 = new Tree();
        addObject(tree5, 240, 295);
        Tree tree6 = new Tree();
        addObject(tree6, 270, 295);

        prepare();

        mainCharacter = m;
        addObject(mainCharacter, 190, 335);         
    }

    /**
     * This method creates all the objects and obstacles in the world.
     */
    private void prepare()
    {
        Rock rock = new Rock();
        addObject(rock, 175, 275);
        Rock rock2 = new Rock();
        addObject(rock2, 150, 275);
        Rock rock3 = new Rock();
        addObject(rock3, 125, 275);
        Rock rock4 = new Rock();
        addObject(rock4, 125, 255);

        Rock rock5 = new Rock();
        addObject(rock5, 150, 235);
        Rock rock6 = new Rock();
        addObject(rock6, 125, 235);
        Rock rock11 = new Rock();
        addObject(rock11, 175, 235);

        Rock rock7 = new Rock();
        addObject(rock7, 190, 190);

        Rock rock8 = new Rock();
        addObject(rock8, 235, 275);

        Rock rock9 = new Rock();
        addObject(rock9, 260, 275);
        Rock rock10 = new Rock();
        addObject(rock10, 260, 255);

        Rock rock12 = new Rock();
        addObject(rock12, 170, 235);
        Rock rock13 = new Rock();
        addObject(rock13, 170, 215);
        Rock rock14 = new Rock();
        addObject(rock14, 170, 195);

        Rock rock15 = new Rock();
        addObject(rock15, 215, 195);
        Rock rock16 = new Rock();
        addObject(rock16, 215, 215);

        Rock rock17 = new Rock();
        addObject(rock17, 215, 235);
        Rock rock18 = new Rock();
        addObject(rock18, 235, 235);
        Rock rock19 = new Rock();   
        addObject(rock19, 260, 235);
        
        Architect architect = new Architect();
        addObject(architect, 241, 258);

        Architect architect2 = new Architect();
        addObject(architect2, 145, 260);
        
        Brock brock = new Brock();
        addObject(brock, 190, 210);

    }
}
