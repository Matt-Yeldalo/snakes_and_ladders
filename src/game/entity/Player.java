package game.entity;

import game.Cell;
import game.Grid;

import java.awt.*;

public class Player extends Cell implements DisplayableEntity{
  Color c;
  Point currentPos;
  static int width = 40, height = 40;

  public Player(int x, int y, Color c){
    super(x + 5, y + 5, width, height);
    currentPos = new Point(x, y);
    System.out.println("Player created");
    this.id = 1;
    this.c = c;
  }

  @Override
  public String toString() {
    return "Player { x: " + x + " y: " + y + " }";
  }

  @Override
  public void display(Graphics g) {
    g.setColor(c);
    g.fillRect(x, y, width, height);
  }

  @Override
  public void move(Cell c) {
    id = c.id;
    this.x = c.x + 5;
    this.y = c.y + 5;
  }
}
