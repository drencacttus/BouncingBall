package bouncingball;

public class BouncingBall {

    public static void main(String[] args) {

        World win = new World(500, 500);
        win.setVisible(true);
        
        win.addWorldObject(new WorldObject(100, 30, 50, 50));
        win.addWorldObject(new WorldObject(30, 160, 30, 30));
        win.addWorldObject(new WorldObject(220, 300, 10, 10));
    }
}
