package game.state;

import game.Cell;
import game.Game;
import game.entity.*;

public class CheckingTile implements GameState{

  Game game;
  public CheckingTile(Game game){
    this.game = game;
  }
  @Override
  public void run() {
    Player player = game.getPlayer();
    Cell topOfLadder = game.getIntersectingLadder(player);
    if (topOfLadder != null){
      player.move(topOfLadder);
    }
    game.setState(new WaitingForInput());
  }

}
