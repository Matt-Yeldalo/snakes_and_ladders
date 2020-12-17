package game;

import java.awt.*;

public class Cell extends Rectangle {
  final static int width = 50, height = 50;
  public int id;

  public Cell(){}

  public Cell(Cell c){
    this.id = c.id;
    this.x = c.x;
    this.y = c.y;
  }

  public Cell(int x, int y){
    super(x, y, width, height);
  }
  public Cell(int x, int y, int width, int height){
    super(x, y, width, height);
  }

  public int getWidthIncremented(){
    return width+1;
  }
  public int getHeightIncremented(){
    return height+1;
  }

  public void drawCell(Graphics g) {
    g.drawRect(x, y, width, height);
    g.drawString(id + "", x + (width / 2), y + (height / 2));
  }
}
