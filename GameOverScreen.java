import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    public GameOverScreen()
    {    
        super(1600, 700, 1); 
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            IntroScreen world = new IntroScreen();
            Greenfoot.setWorld(world);
        }
    }
}
