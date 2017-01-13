public class SquareTarget extends Target {
  public void move (int inc) {
    
    setXcoord(getXcoord() + inc);
    setYcoord(getYcoord() + inc);
  }
  
  public SquareTarget(int x, int y, int size) {
    super(x, y, size, size);
  }
}