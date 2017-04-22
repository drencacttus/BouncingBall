package bouncingball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class World extends JFrame {
    
    ArrayList<WorldObject> objects = new ArrayList<>();

    private Timer tmrTimer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            for(int i = 0;i<objects.size();i++)
                objects.get(i).processPhysics();
            
            repaint();
        }
    });
    
    public World(int width, int height) {
    
        super();
        
        tmrTimer.start();
        
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addWorldObject(WorldObject obj) {
    
        objects.add(obj);
    }
  
    @Override
    public void paint(Graphics g) {
    
        //Krijo nje image per Double Buffering
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        
        
        //E pastron dritaren
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        g2d.setColor(Color.red);
        for(int i = 0;i<objects.size();i++)
            objects.get(i).draw(g2d);

        
        //Vizato image per Double Buffering
        Graphics2D g2dComponent = (Graphics2D) g;
        g2dComponent.drawImage(bufferedImage, null, 0, 0);
    }
}
