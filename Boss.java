import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends ScrollingActor
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 100;
    int speed = 5;
    int mobbyDist = 1000;
    boolean changeDir;
    private int timer;
    private static final int TIMER = 130;
    boolean dead = false;
    
    int size = 1;
    private double runningFrameTime = 0;
    int runningFrameSpeed = 18;
    
    private GreenfootSound gunshot = new GreenfootSound("gunshot.mp3");
    GreenfootImage Img2 = new GreenfootImage("bossRun.png");
    GreenfootImage Img1 = new GreenfootImage("bossStill.png");
    public Boss()
    {
        timer = TIMER;
    }
    
    public void act() 
    {
        // Add your action code here.
        checkHit();
        if (!dead) checkMobby();
    }    
    public void checkMobby()
    {
        List<Mobby> list;  // takes the actor Mobby into the list 
        list = getObjectsInRange(mobbyDist, Mobby.class);
        if (!list.isEmpty())
        {
            pace();
            shoot();
        }

    }
    public void checkHit()
    {
        GlassDebris glassHit = (GlassDebris) getOneIntersectingObject(GlassDebris.class);
        if (glassHit != null)
        {
            getWorld().removeObject(glassHit);
            health -= 20;
            if (health == 0)
            {
                dead = true;
                getWorld().removeObject(this);
                YouWin win = new YouWin();
                Greenfoot.setWorld(win);
            }
        }
    }
    public void pace()
    {
        if (timer != 0)
        {
            move(speed);
            if (runningFrameTime == runningFrameSpeed)
            {
                runningFrameTime = 0;
            }
            if (runningFrameTime == 0) {
                    setImage(Img1);
            }          
            if (runningFrameTime == runningFrameSpeed / 2) {
                    setImage(Img2);
            }
            runningFrameTime++;
            timer--;
        }
        if (timer == 0)
        {
            speed = speed * -1;
            timer = TIMER;
        }
    }
    int shotTimer = 120;
    int shotTime = 120;
    public void shoot()
    {
        Bullet bullet = new Bullet(size);
        shotTimer--;
        if (shotTimer <= 0)
        {
            getWorld().addObject(bullet, getX() - 125, getY() + 55 + size*6);
            gunshot.play();
            bullet.setRotation(180);
            shotTimer = shotTime;
        }
    }
}
