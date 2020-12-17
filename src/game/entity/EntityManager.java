package game.entity;

import game.Cell;
import game.Grid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityManager {
  List<DisplayableEntity> entities;

  public EntityManager(DisplayableEntity... entities){
    this.entities = new ArrayList<>(entities.length);
    this.entities.addAll(Arrays.asList(entities));

  }

  public void displayEntities(Graphics g){
    for (DisplayableEntity entity : entities){
      entity.display(g);
    }
  }

  public Player moveAndGetPlayer(Grid grid, int roll) {
    Player player = getPlayerAndRoll(grid, roll);
    if (player != null){
      return player;
    }
    return null;
  }

  public Player getPlayer(){
    for (DisplayableEntity entity : entities){
      if (isInstanceOf(entity, "Player")){
        return (Player) entity;
      }
    }
    return null;
  }

  private boolean isInstanceOf(DisplayableEntity entity, String className){
    return entity.getClass().getSimpleName().equals(className);
  }
  private Player getPlayerAndRoll(Grid grid, int roll){
    for (DisplayableEntity entity : entities){
      if (isInstanceOf(entity, "Player")){
        Player player = (Player)entity;
        Cell newLoc = grid.validateAndGet(player, roll);
        player.move(newLoc);
        return player;
      }
    }
    return null;
  }


  public Ladder getIntersectingLadder(Player player) {
    for (DisplayableEntity entity : entities){
      if (isInstanceOf(entity, "Ladder")){
        Ladder ladder = (Ladder) entity;
        if (player.contains(ladder.getLadderStart())){
          return (Ladder) entity;
        }
      }
    }
    return null;
  }
}
