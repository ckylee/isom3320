public class TestProgram{
  public static void main(String[] args) {
    int y = (int) (Math.random() * 61 + 10);
    
    Target[] objects = new Target[10];
    Bullet b;
    
    //fill in target objects
    for(int i = 0; i < 5; i++) {
      objects[i] = new Target(90, y, 5, 3);
    }
    
    //fill in squaretarget objects
    for (int i=5; i < objects.length; i++) {
      objects[i] = new SquareTarget(90, y, 4);
    }
    
   for(int i = 0; i < 10; i++) {
    for(int j=0; j < 10; j++) {
      y = (int) -(Math.random() * 5 + 1);
      objects[j].move(y);
      System.out.println("Target " + j + objects[i] + " moved to " + objects[j]);
    }
   }
   
   //create 10 bullets to test static and nonstatic variables
   for(int i = 0; i < 10; i++) {
     b = new Bullet(1,1,1);
   }
   
  }
}