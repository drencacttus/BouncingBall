package bouncingball;

import java.awt.Graphics;

public class WorldObject {
    
    private int posX, posY, velX = 3, velY, accX, accY = 1;
    private int width, height;
    
    public WorldObject(int x, int y, int width, int heigh) {
    
        posX = x;
        posY = y;
        
        this.width = width;
        this.height = heigh;
    }
    
    void processPhysics() {
    
        velX += accX;
        velY += accY;
        
        posX += velX;
        posY += velY;
        
        if(posY > 420 - height) {
        
            velY = -(int)(velY * 0.8);
            posY = 420 - height;
        }
    }
    
    void draw(Graphics g) {
    
        g.fillOval(posX, posY, width, height);
    }
}
