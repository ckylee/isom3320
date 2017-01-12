public class TestDriver {
  public static void main(String[] args) {
    Bullet bullet1 = new Bullet(0,0,1);
    Bullet bullet2 = new Bullet(0,0,1);
    Target target = new Target(5,0,10,10);
    
    for(int i = 0; i < 10; i++) {
      bullet1.move(1);
      System.out.println("Bullet 1 moved to" + bullet1);
      
      bullet2.move(1);
      System.out.println("Bullet 2 moved to" + bullet2);
      
      target.move(-1);
      System.out.println("Target moved to" + target);
      
      if(bullet1.isHit(target) || bullet2.isHit(target))
        System.out.println("Bingo!");
      
    }
  }
}