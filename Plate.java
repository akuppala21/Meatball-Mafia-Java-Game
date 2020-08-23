import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plate extends ScrollingActor
{
    /**
     * Act - do whatever the Plate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int rollDirection;
    public Plate(int size, int direction)
    {
        GreenfootImage image = getImage();
        image.scale(87 + size * 12, 87 + size * 12);
        setImage(image);
        rollDirection = direction;
    }
    public void act() 
    {
        setLocation(getX() + 5*rollDirection, getY());
        turn(5*rollDirection);
        checkRemove();
    }    
    public void checkRemove()
    {
        World w = getWorld();
        if (getY() > w.getHeight() || getX() > w.getWidth())
        {
            w.removeObject(this);
        }
    }
}
