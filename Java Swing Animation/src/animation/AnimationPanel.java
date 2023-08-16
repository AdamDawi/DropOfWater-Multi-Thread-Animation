package animation;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimationPanel extends JPanel
{
    private Thread thread;
    private ArrayList<DropOfWater> DropOfWaterList = new ArrayList<DropOfWater>();
    private ThreadGroup threadGroup = new ThreadGroup("Thread Group");
    private JPanel panel = this;
    private int DropOfWaterSize = 10;
    private volatile boolean stopped = false; 
    private Object lock = new Object(); //for synchoronize 

    AnimationPanel()
    {
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(300, 400));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D)g;
        G2D.setColor(Color.blue);

        for(int i=0; i<DropOfWaterList.size(); i++)
        {
            G2D.fillOval(((DropOfWater)(DropOfWaterList.get(i))).getX(), ((DropOfWater)(DropOfWaterList.get(i))).getY() , DropOfWaterSize, DropOfWaterSize);
        }
    }

    public void start()
    {
        if(stopped)
        {
            stopped=false;
            synchronized(lock)
            {
                lock.notifyAll();
            }
        }
    }

    public void stop()
    {
        stopped = true;
    }

    public void addDropOfWater()
    {
        DropOfWaterList.add(new DropOfWater());
        thread = new Thread(threadGroup, new DropOfWaterRunnable((DropOfWater)DropOfWaterList.get(DropOfWaterList.size()-1)));
        thread.start();

        repaint();
        threadGroup.list();
    }

    public class DropOfWaterRunnable implements Runnable
    {
        private DropOfWater water;

        DropOfWaterRunnable(DropOfWater water)
        {
            this.water = water;
        }

        @Override
        public void run() 
        {

            while(true)
            {
                synchronized(lock)
                {
                    while(stopped)
                    {
                        try 
                        {
                            lock.wait();
                        } 
                        catch (InterruptedException e) 
                        {
                            e.printStackTrace();
                        }
                    }
                }
                this.water.moveWater(panel);
                repaint();
                try 
                {
                    Thread.sleep(1);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        
    }
}

class DropOfWater
    {
        private int x=0;
        private int y=0;
        private int xVelocity=1;
        private int yVelocity=1;
        private int DropOfWaterSize = 10;

        public int getX(){return x;}
        public int getY(){return y;}

        public void moveWater(JPanel panel)
        {
            Rectangle panelBounds = panel.getBounds();
            x += xVelocity;
            y += yVelocity;

            if (y + DropOfWaterSize >= panelBounds.getMaxY()) {
                y = (int) (panelBounds.getMaxY() - DropOfWaterSize);
                yVelocity = -yVelocity;
            }
            if (x + DropOfWaterSize >= panelBounds.getMaxX()) {
                x = (int) (panelBounds.getMaxX() - DropOfWaterSize);
                xVelocity = -xVelocity;
            }
            if (y < panelBounds.getMinY()) {
                y = (int) panelBounds.getMinY();
                yVelocity = -yVelocity;
            }

            if (x < panelBounds.getMinX()) {
                x = (int) panelBounds.getMinX();
                xVelocity = -xVelocity;
            }
        }
    }
