package game.entity;

import game.Cell;

import java.awt.*;

public interface DisplayableEntity {
  void display(Graphics g);

  void move(Cell c);
}
