package game.entity;

import game.Cell;

import java.awt.*;

public class Ladder implements DisplayableEntity{
  final int WIDTH = 40;
  Rail leftRail;
  Rail rightRail;
  public Ladder(Cell bottom, Cell top){
    leftRail = new Rail(new Point(top.x + (WIDTH / 10), top.y + (int)top.getHeight() /2), new Point(bottom.x + (WIDTH / 10),bottom.y + (int)bottom.getHeight() /2));

    rightRail = new Rail(new Point(top.x + WIDTH, top.y + (int)top.getHeight() /2), new Point(bottom.x + WIDTH,bottom.y + (int)bottom.getHeight() /2));
  }
  @Override
  public void display(Graphics g) {
    g.setColor(Color.RED);
    g.drawLine(leftRail.bottom.x, leftRail.bottom.y, leftRail.top.x, leftRail.top.y);

    g.drawLine(rightRail.bottom.x, rightRail.bottom.y, rightRail.top.x, rightRail.top.y);
  }

  @Override
  public String toString() {
    return "Ladder { x: " + rightRail.bottom.x + " y: " + rightRail.bottom.y;
  }

  @Override
  public void move(Cell c) {

  }
  public Point getLadderTop(){
    return rightRail.top;
  }
  public Point getLadderStart(){
    return rightRail.bottom;
  }
  private class Rail{
    Point top;
    Point bottom;
    Rail(Point top, Point bottom){
      this.top = top;
      this.bottom = bottom;
    }
  }
}
