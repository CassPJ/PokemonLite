import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class BattleScreen here.
 * 
 * @Cassidy Powell-Jones && Derek Liew 
 * @June 2015
 */
public class BattleScreen extends World
{
    GreenfootSound music = new GreenfootSound ("battle.mp3");
    private Trainer a; 
    //Trainer b should become player once the player class comes into play
    private MainCharacter b;  
    private Pokemon enemy;
    private Pokemon yours;
    private int turn = 0;
    private int cinematic = 0;
    private int speed = 0;
    private Textbox texts;
    private boolean wants = false;
    private boolean sends = false;
    private boolean shown = false;
    private boolean go = false;
    private boolean battleStart = false;
    private boolean enemyAttacked = false;
    private boolean attackDisplay = false;
    private Text attOne;
    private Text attTwo;
    private Text attThree;
    private Text attFour;
    private Text pOne;
    private Text pTwo;
    private ScrollingWorld oldWorld;
    private PokemonWorld oldPWorld;
    private GymWorld oldGWorld;
    private Text pThree ;
    private Text pFour;
    private Text pFive;
    private Text pSix;
    private Pokemon gained;
    private String enemyAtt;
    private InfoBar infobar;
    private InfoBar infobar2;
    /**
     * Constructor for objects of class BattleScreen.
     * 
     */
    public BattleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }   

    public BattleScreen(Trainer t, MainCharacter s, ScrollingWorld p){
        super(600, 400, 1);
        a = t;
        b = s; 
        oldWorld = p;
        music.playLoop();
        enemy = a.getPokemonOne();
        yours = b.getPokemonOne();
        prepare();
    }

    public void stopMusic(){
        music.stop();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        infobar2 = new InfoBar(yours.getName(), yours.getLevel(), yours.getHealth(), yours.getFullHealth(), yours.getExp(), yours.getTotExp(), "F");       
        // BattleText battletext = new BattleText();
        // addObject(battletext, 304, 361);
        // battletext.setLocation(300, 353);
        // infobar.setLocation(453, 262);
        infobar = new InfoBar(enemy.getName(), enemy.getLevel(), enemy.getHealth(), enemy.getFullHealth(), enemy.getExp(), enemy.getTotExp(), "F");
        addObject(infobar2, 452, 281);
        addObject(infobar, 158, 86);
        PickMenu pickmenu = new PickMenu();
        addObject(pickmenu, 484, 356);
        pickmenu.setLocation(439, 340);     
        removeObject(pickmenu);
    }

    public void act(){
        if(shown == false){        
            showTrainer();     
            shown = true;
        }        
        a.move(speed);        
        //shows text "this trainer wants to battle"
        if(wants == false){
            if(Greenfoot.isKeyDown("enter")){
                texts = new Textbox(wantsToBattle());            
                addObject(texts, 400, 370);
                speed = 1;
                wants = true;
            }
        }        
        //makes the trainer disappear
        if(wants == true && sends == false && a.getX() == this.getWidth() - 1){
            if(Greenfoot.isKeyDown("enter")){
                texts.update(sendsOut(enemy));            
                showPokemon(yours, enemy);
                speed  = 1;
                Greenfoot.delay(20);
                sends = true;
                removeObject(a);
            }
        }
        if(sends == true && battleStart == false && yours.getAttackOne() != null){
            if(Greenfoot.isKeyDown("enter")){
                texts.update("Go " + yours.getName() + "!!"); 
                Greenfoot.delay(2);
                go = true;
            }
        }       
        if(go == true){
            if(Greenfoot.isKeyDown("enter")){
                battleStart = true;
            }
        }
        if(battleStart == true && enemy.fainted() == false && yours.fainted() == false){
            battle();
        }
        if(enemy.fainted() == true){
            texts.update(enemy.getName() + " fainted!");
            stopMusic();
            infobar = new InfoBar(enemy.getName(), enemy.getLevel(), enemy.getHealth(), enemy.getFullHealth(), enemy.getExp(), enemy.getTotExp(), "F");
            yours.addExp(enemy.getLevel());
            Greenfoot.delay(10);
            if(a.getPokemonTwo().fainted() == false){
                enemy = a.getPokemonTwo();
                addObject(enemy, 450, 80);
                infobar = new InfoBar(enemy.getName(), enemy.getLevel(), enemy.getHealth(), enemy.getFullHealth(), enemy.getExp(), enemy.getTotExp(), "F");
                texts.update(sendsOut(enemy));
            } else{
                addObject(a, 500, 100);
                pokeAward();
                texts.update("You win!");
                stopMusic();                
                Greenfoot.delay(5);                 
                removeObject(infobar);
                removeObject(infobar2);
                battleStart = false;
                infobar = null;
                infobar2 = null;
                texts.update("An " + gained.getName() + " has been added to your inventory!");
                b.addToPokeBank(gained);
                Greenfoot.delay(5);
                if(oldWorld instanceof PokemonWorld){
                    oldPWorld = (PokemonWorld)oldWorld;
                    Greenfoot.setWorld(oldPWorld);
                } 
                if(oldWorld instanceof GymWorld){
                    oldGWorld = (GymWorld)oldWorld;
                    Greenfoot.setWorld(oldGWorld);
                }
            }
        }
        if(yours.fainted() == true){         
            texts.update("You lost");
            stopMusic();
            Greenfoot.setWorld(new PokeCentreWorld(b, b.getPokemonOne()));
        }
    }

    public void battle(){
        Random r = new Random();
        int attNum = r.nextInt(4);
        if(Greenfoot.isKeyDown("enter") && enemyAttacked == false){
            texts.update(" ");
        }
        if(turn % 2 == 0 && enemyAttacked == false){           
            if(Greenfoot.isKeyDown("enter")){
                chooseAttack();
            }
        }        
        if(turn % 2 == 0 && battleStart == true){
            if(Greenfoot.mouseClicked(attOne)){
                enemy.getAttacked(yours.getAttackOne(), yours.getAttackOneType(), yours.getAttPow(), yours.getSpecAttPow()); 
                removeAttacks();
                texts.update(uses(yours, yours.getAttackOne()));
                turn++;
            }
            if(Greenfoot.mouseClicked(attTwo)){
                enemy.getAttacked(yours.getAttackTwo(), yours.getAttackTwoType(), yours.getAttPow(), yours.getSpecAttPow());
                removeAttacks();
                texts.update(uses(yours, yours.getAttackTwo()));
                //enemyAttacked = true;
                turn++;
            }
            if(Greenfoot.mouseClicked(attThree)){
                enemy.getAttacked(yours.getAttackThree(), yours.getAttackThreeType(), yours.getAttPow(), yours.getSpecAttPow());
                removeAttacks();
                texts.update(uses(yours, yours.getAttackThree()));
                enemyAttacked = true;
                turn++;
            }
            if(Greenfoot.mouseClicked(attFour)){
                enemy.getAttacked(yours.getAttackFour(), yours.getAttackFourType(), yours.getAttPow(), yours.getSpecAttPow());
                removeAttacks();
                texts.update(uses(yours, yours.getAttackFour()));
                enemyAttacked = true;
                turn++;
            }
            infobar2.updateHealth(yours.getFullHealth(), yours.getHealth());
        } 
        String attName = ""; 
        if(turn % 2 == 1){// && enemyAttacked == true){ 
            if(Greenfoot.isKeyDown("enter")){
                enemyAttacked = true;
            }
        }
        if(turn % 2 == 1 && enemyAttacked == true ){
            removeAttacks();
            if(Greenfoot.isKeyDown("enter")){
                if(attNum == 0){
                    attName = enemy.getAttackOne();
                    enemyAtt = enemy.getAttackOneType();
                }
                if(attNum == 1){
                    if (enemy.getAttackTwo() != " "){
                        attName = enemy.getAttackTwo(); 
                        enemyAtt = enemy.getAttackTwoType();
                    } else { 
                        attName = enemy.getAttackOne();
                        enemyAtt = enemy.getAttackOneType();
                    }
                }
                if(attNum == 2){
                    if (enemy.getAttackThree() != " "){
                        attName = enemy.getAttackThree();
                        enemyAtt = enemy.getAttackThreeType();
                    } else { 
                        attName = enemy.getAttackOne();
                        enemyAtt = enemy.getAttackOneType();
                    }
                }
                if(attNum == 3){
                    if (enemy.getAttackFour() != " "){
                        attName = enemy.getAttackFour();
                        enemyAtt = enemy.getAttackFourType();
                    } else { 
                        attName = enemy.getAttackOne();
                        enemyAtt = enemy.getAttackOneType();
                    }
                }
            }
            texts.update(uses(enemy, attName));
            Greenfoot.delay(30);            
            yours.getAttacked(attName, enemyAtt, enemy.getAttPow(), enemy.getSpecAttPow()); 
            infobar.updateHealth(enemy.getFullHealth(), enemy.getHealth());
            enemyAttacked = false;
            attackDisplay = false;     
            turn++;
        }
    }

    /**
     * Sets the text for the textboxes
     * @returntext The text that will be shown in the textbox
     */
    public String wantsToBattle(){
        String text = a.getName() + " wants to battle! (Enter)";        
        return text;
    }

    /**
     * Sets the text for the textboxes
     * @paramp The Pokemon being sent out
     * @returntext The text that will be shown in the textbox
     */
    public String sendsOut(Pokemon p){
        String text = a.getName() + " sends out " + p.getName();
        return text;
    }

    public void pokeMovement(Pokemon p){
        for (int i = 0; i < 20; i ++){
            p.move(1);
        }
        for (int i = 0; i < 40; i ++){
            p.move(-1);
        }
        for (int i = 0; i < 20; i ++){
            p.move(1);
        }
    }

    /**
     * Sets the text for the textboxes
     * @paramp String The pokemong using the move
     * @parammove String The move being used
     * @returntext The text that will be shown in the textbox
     */
    public String uses (Pokemon p, String move){
        String text = p.getName() + " uses " + move + "!";        
        return text;
    }

    /**
     * Sets the trainer 
     */
    public void showTrainer(){    
        addObject(a, 500, 100);
    }

    /**
     * Shows the pokemon
     * @paramyou Pokemon your Pokemon(probably called b)
     * @paramthey Pokemon the enemy's Pokemon (probably called a)
     * 
     */
    public void showPokemon(Pokemon you, Pokemon they){        
        addObject(you, 110, 290);
        addObject(they, 450, 80);  
    }

    /**
     * Makes the trainer move off to the side
     */
    public void trainerLeave(){
        a.move(1);    
    }

    public void chooseAttack(){
        if(attackDisplay == false){
            enemyAttacked = false;
            Text choose = new Text("Choose your attack");
            addObject(choose, 240, 320);
            attOne = new Text(yours.getAttackOne());
            attTwo =  new Text(yours.getAttackTwo());
            attThree =  new Text(yours.getAttackThree());
            attFour =  new Text(yours.getAttackFour());
            addObject(attOne, 240, 360);
            addObject(attTwo, 240, 380);
            addObject(attThree, 550, 360);
            addObject(attFour, 550, 380);
            attackDisplay = true;
        }
    }

    public void removeAttacks(){
        removeObject(attOne);
        removeObject(attTwo);
        removeObject(attThree);
        removeObject(attFour);
    }

    public Pokemon pokeAward(){
        Random r = new Random();
        int x = r.nextInt(5);
        Pokemon reward = new Pokemon();
        if (x == 0){
            reward = new Growlithe();
        }
        if (x == 1){
            reward = new Pidgey();
        }
        if (x == 2){
            reward = new Onix();
        }
        if (x == 3){
            reward = new Butterfree();
        }
        if (x == 4){
            reward = new Pikachu();
        }
        gained = reward;
        return reward;
    }

}
