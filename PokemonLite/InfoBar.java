import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Font;
import java.awt.Color;
/**
 * Is a bar that contains all the information from the pokemon such as health and experience along with change them
 * 
 * @author Derek Liew
 * @version v1
 */
public class InfoBar extends Actor
{
    private GreenfootImage front = new GreenfootImage("fullhp.png");
    private GreenfootImage back  = new GreenfootImage("fullhp flipped.png");
    private GreenfootImage myImage;
    private int currentHp,totalHp,level,currentExp,totalExp;
    private String name,side;
    public InfoBar(String nom,int lvl,int cHp,int tHp,int cExp,int tExp,String s){
        if(this != null){
            currentHp=cHp;
            totalHp=tHp;
            level=lvl;
            side=s;
            name=nom;
            totalExp=tExp;
            currentExp=cExp;
            if(side=="F"){
                myImage=front;
            }else{
                myImage=back;
            }
            setImage(myImage);
            this.ifHealthLow();
            this.displayName();
            this.displayLevel();
            this.updateHealth(totalHp,currentHp);
            this.updateExp(totalExp,currentExp);
        }
    }

    public void act(){
        this.ifHealthLow();
        this.displayName();
        this.displayLevel();
        this.updateHealth(totalHp,currentHp);
        this.updateExp(totalExp,currentExp);
    }

    /**
     * This method cahgnes the pictures of the health bar color as the health reachs a point
     */
    public void ifHealthLow(){
        double cHp=(double)currentHp;
        double tHp=(double)totalHp;
        double percent=((cHp/tHp)*100);
        if(percent<=30&&percent>10){
            if(side=="F"){
                setImage("lowhp.png");
            }else{
                setImage("lowhp flipped.png");
            }
        }else if(percent<=10){
            if(side=="F"){
                setImage("redhp.png");
            }else{
                setImage("redhp flipped.png");
            }
        }else{
            if(side=="F"){
                setImage("fullhp.png");
            }else{
                setImage("fullhp flipped.png");
            }
        }

    }

    /**
     * This method writes the numbers of the health above the health bare and covers it as a percentage
     * @param total is a int of total health possible
     * @param changed is a int of the new health value
     */

    public void updateHealth(int total,int changed)
    {   
        int caLength;
        int c = changed;
        int t = total;
        currentHp=changed;
        totalHp=total;
        double cHp=(double)changed;
        double tHp=(double)total;
        double percent=((cHp/tHp)*100);
        //Displays the blue text for the number
        String amount1 = "" + c + "/" + t;
        Color textColor = new Color(129,199,220);
        GreenfootImage text = getImage();
        text.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 18));
        text.setColor(textColor);
        if(side=="F"){
            text.drawString(amount1, 67, 46);
        }else{
            text.drawString(amount1, 91, 46);
        }
        //Calculates the percentage of the total amount to the bar
        double devided = (1.39);
        double convert = ((cHp/tHp)*100);
        double last =  (devided * (100-convert));
        caLength= (int) last;
        //sets up the cover for the visual bar
        //         GreenfootImage cover = new GreenfootImage(caLength+1,10);
        //         Color filler = new Color(255,255,255);
        //         cover.setColor(filler);
        //         cover.fill();
        //         if(side=="F"){
        //             myImage.drawImage(cover,(259-(caLength+1)),53);
        //         }else{
        //             myImage.drawImage(cover,(284-(caLength+1)),53);
        //         }

    }

    /**
     * This method writes the name of the pokemon as a txt string
     */
    public void displayName(){
        Color textColor = new Color(0,0,0);
        GreenfootImage text = getImage();
        text.setFont(new java.awt.Font("Helvetica",java.awt.Font.PLAIN, 25));
        text.setColor(textColor);
        if(side=="F"){
            text.drawString(name, 10, 30);
        }else{
            text.drawString(name, 31, 30);
        }
    }

    /**
     * This method writes the level of the pokemon as a int string
     */
    public void displayLevel(){
        Color textColor = new Color(62,62,62);
        GreenfootImage text = getImage();
        text.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 29));
        text.setColor(textColor);
        if(side=="F"){
            text.drawString(Integer.toString(level), 222, 42);
        }else{
            text.drawString(Integer.toString(level), 244, 42);
        }
    }

    /**
     * This method that changes the health bar piece by piece
     * @param amtChange is a int  that is the amount of health being changed
     */
    public void changeHp(int amtChange){
        for(int i=0;i<amtChange;i++){   
            updateHealth(totalHp,(currentHp+amtChange));
        }
        if(currentHp>=totalHp){
            currentHp=totalHp;
        }else{
            currentHp+=amtChange;
        }

    }

    /**
     * This method that chagnes the exp bar by the amount given
     * @param total is the total amount of exp
     * @param changed is the amount of exp being given
     */
    public void updateExp(int total,int changed){
        int caLength;
        int c=changed;
        int t=total;
        double cHp=(double)changed;
        double tHp=(double)total;
        double percent=((cHp/tHp)*100);
        //Displays the blue text for the number
        String amount1 = "" + c + "/" + t;
        Color textColor = new Color(80,150,155);
        GreenfootImage text = getImage();
        text.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 10));
        text.setColor(textColor);
        if(side=="F"){
            text.drawString(amount1, 8, 70);
        }else{
            text.drawString(amount1, 31, 70);
        }
        //Calculates the percentage of the total amount to the bar
        double devided = (1.39);
        double convert = ((cHp/tHp)*100);
        double last =  (devided * (100-convert));
        caLength= (int) last;
        //set up for bar background
        GreenfootImage backg = new GreenfootImage("expbar.png");
        backg.fill();
        myImage.drawImage(backg,8,100);
        //sets up the cover for the visual bar        
        GreenfootImage cover = new GreenfootImage(caLength+1,10);
        Color filler = new Color(255,255,255);
        cover.setColor(filler);
        cover.fill();
        myImage.drawImage(cover,(259-(caLength+1)),53);

    }

    /**
     * This method that cahgnes the exp bar piece by piece
     * @param amtChange is a int that is the amount of exp being changed
     */
    public void changeExp(int amtChange){
        for(int i=0;i<amtChange;i++){   
            updateExp(totalExp,(currentExp+amtChange));
        }
        if(currentHp>=totalHp){
            currentHp=totalHp;
        }else{
            currentHp+=amtChange;
        }
    }

}
