public class TestDriver {
    public static void main(String[] args) {
        Bullet a = new Bullet(2, 5, 1);
        Bullet b = new Bullet(0, 9, 1);
        Target t = new Target(80, 6, 4, 3);
        

        for(int i = 1; i <= 10; i++) {
            a.move(10);
            System.out.println("After moved, Bullet A: " + a);
            b.move(10);
            System.out.println("After moved, Bullet B: " + b);
            t.move(-4);
            System.out.println("After moved, Target t: " + t);
            
            if(a.isHit(t)) 
                System.out.println("Bingo! Bullet A hits target");
            
            if(b.isHit(t)) 
                System.out.println("Bingo! Bullet B hits target");
            
        }
    }
}