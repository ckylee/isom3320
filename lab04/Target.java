public class Target {
    private int xcoord;
    private int ycoord;
    private int width;
    private int height;
    
    public Target(int x, int y, int w, int h) {
        xcoord = x;
        ycoord = y;
        width = w;
        height = h;
    }
    
    public Target() {
        xcoord = ycoord = width = height = 0;
    }
    
    public void setXcoord(int x) {
        xcoord = x;
    }
    
    public void setYcoord(int y) {
        ycoord = y;
    }
    
    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getXcoord() {
        return xcoord;
    }
    
    public int getYcoord() {
        return ycoord;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return "(x, y, w, h) = (" + xcoord + ", " + ycoord + ", " + width + ", " + height + ")";
    }
    
    public void move(int inc) {
        xcoord += inc;
    }
}