package game.display;

import java.awt.*;

public class DisplayManager extends Rectangle {
  Color c;

  public DisplayManager(int x, int y, int width, int height){
    super(x, y, width, height);
    c = new Color(200, 200, 200);
  }

  public void display(Graphics g){
    g.setColor(c);
    g.fillRect(x, y, width, height);
  }
}
