package game.entity;

import game.Cell;

import java.awt.*;

public class Snake implements DisplayableEntity{

  Point head;
  Point tail;
  public Snake(Cell head, Cell tail){
    this.head = new Point(head.x, head.y);
    this.tail = new Point(tail.x, tail.y);
  }

  @Override
  public void display(Graphics g) {
    g.drawLine(tail.x, tail.y, head.x, head.y);
  }

  @Override
  public void move(Cell c) {

  }
}
