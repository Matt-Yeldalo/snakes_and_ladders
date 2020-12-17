package game.state;

import game.Game;

import java.util.Random;

public class Rolling implements GameState{

  Game game;
  public Rolling(Game game){
    this.game = game;
  }
  static Random dice = new Random();
  @Override
  public void run() {
    int roll = dice.nextInt(6);
    roll++;
    // Move player
    game.movePlayer(roll);
    game.setState(new CheckingTile(game));

  }
}
