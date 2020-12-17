import game.Game;
import game.display.DisplayManager;
import game.state.Rolling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;

public class Main extends JFrame {
  static final int WIDTH = 850;
  static final int HEIGHT = 550;
  static final Color BACKGROUND_COLOR = new Color(220, 220, 220);

  private Main(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Init init = new Init();
    setContentPane(init);
    pack();
    // Appear in center of screen
    setLocationRelativeTo(null);
    setBackground(BACKGROUND_COLOR);
    setVisible(true);
  }
  void gameLoop(){
    while (true){
      Instant start = Instant.now();
      repaint();
      Instant end = Instant.now();
      long timeToPaint = Duration.between(start, end).toMillis();
      try {
        Thread.sleep(60 - timeToPaint);
      }catch (Exception e){
        System.out.println(e);
      }
    }
  }
  public static void main(String[] args) {
    Main main = new Main();
    main.gameLoop();
  }
  class Init extends JPanel{
    // main game variables
    Game game;
    DisplayManager displayManager;
    Init(){
      setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
      setFocusable(true);
      setOpaque(true);
      requestFocus();
      // Init game variables
      game = new Game();
      displayManager = new DisplayManager(520, 5, 250, 520);

      // Key bindings
      getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
      getActionMap().put("space", space);
    }
    Action space = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.setState(new Rolling(game));
      };
    };
    @Override
    public void paint(Graphics g) {
      game.draw(g);
      displayManager.display(g);
    }
  }
}
