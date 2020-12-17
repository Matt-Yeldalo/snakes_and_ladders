package game;

import game.entity.*;
import game.state.GameState;
import game.state.Rolling;

import java.awt.*;

public class Game {
  Grid grid;
  EntityManager entityManager;
  GameState state;


  public Game(){
    grid = new Grid(5, 5);
    entityManager = new EntityManager(
      new Player(Grid.START.x, Grid.START.y, new Color(50, 120, 200)),
      new Ladder(grid.getCellById(16), grid.getCellById(53)),
      new Snake(grid.getCellById(30), grid.getCellById(71))

    );
  }

  public void setState(GameState state){
    this.state = state;
  }

  public void draw(Graphics g){
    if (state != null){
      state.run();
    }
    grid.drawGrid(g);
    entityManager.displayEntities(g);
  }
  public Player getPlayer(){
    return entityManager.getPlayer();
  }

  public Cell getIntersectingLadder(Player player){
    Ladder ladder = entityManager.getIntersectingLadder(player);
    if (ladder != null){
      System.out.println("Ladder found");
      return grid.getCellByPoint(ladder.getLadderTop());
    }
    return null;
  }

  public void movePlayer(int roll) {
    Player player = entityManager.moveAndGetPlayer(grid, roll);
  }

}
