public class Bullet {
    private int xcoord;
    private int ycoord;
    private int radius;
    private static int bulletNumStatic;
    private int bulletNumNonStatic;

    public Bullet(int x, int y, int r) {
        xcoord = x;
        ycoord = y;
        radius = r;
        bulletNumStatic++;
        bulletNumNonStatic++;
        
        System.out.print("Static Value " + bulletNumStatic);
        System.out.println(" Instance Value " + bulletNumNonStatic);
    }
 
    public Bullet() {
        this(1,1,1);
    }

    public void setXcoord(int x) {
        xcoord = x;
    }
    
    public void setYcoord(int y) {
        ycoord = y;
    }    
    
    public int getXcoord() {
        return xcoord;
    }
    
    public int getYcoord() {
        return ycoord;
    }
    
    public String toString() {
        return "(x, y, r) = (" + xcoord + ", " + ycoord + ", " + radius + ")";
    }

    public void move(int inc) {
        xcoord += inc;
    }
 
    public boolean isHit(Target t) {
        int x = t.getXcoord();
        int y = t.getYcoord();
        int w = t.getWidth();
        int h = t.getHeight();

        return (xcoord > x - radius && xcoord < x + w + radius 
                    && ycoord > y - radius && ycoord < y + h + radius) ? true : false;
    }
}