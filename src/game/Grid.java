package game;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

public class Grid implements Iterable<Cell> {
  Cell[][] cells;
  HashMap<Integer, Cell> cellMap;
  final static int width = 500, height = 500;
  static Cell START;
  int xOffSet, yOffSet;
  int row = 10;
  int col = 10;

  Grid(int xOffSet, int yOffSet){
    this.xOffSet = xOffSet;
    this.yOffSet = yOffSet;
    initGrid();
  }
  private void initGrid(){
    cells = new Cell[row][col];
    int counter = row * col;
    for (int i = 0; i < cells.length; i++){
      for (int j = 0; j < cells[i].length; j++){
        cells[i][j] = new Cell(xOffSet + (i + (Cell.width * i)), yOffSet + (j + (Cell.height * j)));
        cells[i][j].id = counter;
        counter--;
      }
    }
    START = cells[0][9];
    cellMap = new HashMap<>();
    setUpIds();
  }

  public Cell getCellByPoint(Point p){
    for (Cell c : this){
//      if (p.equals(new Point(c.x, c.y))){
//        return c;
        if (c.contains(p)){
          return c;
      }
    }
    return new Cell();
  }

  private void setUpIds() {
    int id = 1;
    int xPos = START.x;
    int yPos = START.y;
    boolean goingRight = true;
    while (id <= row * col){
      Cell c = getCellByPoint(new Point(xPos, yPos));
      cellMap.put(id, c);
      // right
      if (goingRight){
        int nextPos = c.x + c.getWidthIncremented();
        c.id = id;
        // If at the window border move up a row
        // Else keep going right
        if (nextPos >= width){
          yPos -= c.getHeightIncremented();
          goingRight = false;
        }else{
         xPos += c.getWidthIncremented();
        }
      }
      // left
      else {
        int nextPos = c.x - c.getWidthIncremented();
        c.id = id;
        //increment id
        if (nextPos <= 0){
          yPos -= c.getHeightIncremented();
          goingRight = true;
        }else{
          xPos -= c.getWidthIncremented();
        }
      }
      id++;
    }
  }

  void drawGrid(Graphics g){
    for (Cell c : this){
      c.drawCell(g);
    }
  }

  @Override
  public Iterator<Cell> iterator() {
    return new GridIterator(cells);
  }

  public Cell validateAndGet(Cell c, int roll) {
    int newId = c.id + roll;
    Cell possibleLoc = getCellById(newId);
    if (possibleLoc != null){

      System.out.println("Valid move, moving " + c.id + " to square " + possibleLoc.id);
      return new Cell(possibleLoc);
    }
    return new Cell();
  }

  public Cell getCellById(int id) {
    for (Cell c : this){
      if (c.id == id){
        return c;
      }
    }
    return null;
  }
}
