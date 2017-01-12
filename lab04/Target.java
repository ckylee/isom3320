public class Target {
  private static int upleftx, uplefty, width, height;
  
  Target() {
    int upleftx, uplefty, width, height = 0;
  }
  
  Target(int newupleftx, int newuplefty, int newwidth, int newheight) {
    upleftx = newupleftx;
    uplefty = newuplefty;
    width = newwidth;
    height = newheight;
  }
  
   public String toString() {
    return "(x, y, w, h) = (" + upleftx + ", " + uplefty + ", " + width + ", " + height + ")"; 
  }
 
   public void move(int add){
    upleftx += add;
  }
   
   public static int collideLeft() {
     return (int) upleftx - Bullet.getRadius();
   }
   
   public int collideRight() {
     return (int) upleftx + width + Bullet.getRadius();
   }
   
   public int collideBottom() {
     return (int) uplefty - height - Bullet.getRadius();
   }
   
   public int collideTop() {
     return (int) uplefty + Bullet.getRadius();
   }
}