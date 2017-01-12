public class Bullet {
  private static int xcoord, ycoord, radius;
  
  Bullet() {
    int xcoord, ycoord, radius = 0;
  }
  
  Bullet(int newxcoord, int newycoord, int newradius) {
    xcoord = newxcoord;
    ycoord = newycoord;
    radius = newradius;
  }
  
  public static int getRadius() {
    return radius;
  }
  
    
  public String toString() {
    return "(x, y, r) = (" + xcoord + ", " + ycoord + ", " + radius + ")"; 
  }
  
  public void move(int add){
    xcoord += add;
  }
  
  
  public boolean isHit(Target t) {
          boolean hit;
          if ((((xcoord + radius) > t.collideLeft()) && ((xcoord) < t.collideRight()))
                && (((ycoord + radius) > t.collideBottom()) && ((ycoord) < t.collideTop())))
          {
            hit = true;
          }
          else
          {
            hit = false;
          }

          return hit;
  }
}