package game;

import java.util.Iterator;

public class GridIterator implements Iterator<Cell> {
  Cell[][] cells;
  int i,j;

  GridIterator(Cell[][] cells){
    this.cells = cells;
  }

  @Override
  public boolean hasNext() {
    return i < cells.length && j < cells[i].length;
  }

  @Override
  public Cell next() {
    Cell c = cells[i][j];
    if (j >= cells[i].length-1){
      i++;
      j = 0;
    }else{
      j++;
    }
    return c;
  }
}
