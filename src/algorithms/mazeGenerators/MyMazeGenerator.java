package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {


    @Override
    public Maze generate(int row, int col) {
        Maze maze = new Maze(row, col);

        ArrayList<Position> positionQueue = new ArrayList<Position>();
        positionQueue.add(maze.getStartPosition());
        while (!positionQueue.isEmpty()) {
            int rd = (int) ((Math.random() * positionQueue.size()));
            Position t = positionQueue.get(rd);
            positionQueue.remove(rd);
            t.setVisited(true);
            int x = t.getRowIndex();
            int y = t.getColumnIndex();
            maze.set_val(x, y, 0);
            if (t.getPrev() != null) {
                if (x != t.getPrev().getRowIndex()) {
                    if (x > t.getPrev().getRowIndex()) {
                        maze.getPosition(x - 1, y).setVisited(true);
                        maze.getPosition(x - 1, y).setVal(0);
                    } else {
                        maze.getPosition(x + 1, y).setVisited(true);
                        maze.getPosition(x + 1, y).setVal(0);
                    }
                }
                if (y != t.getPrev().getColumnIndex()) {
                    if (y > t.getPrev().getColumnIndex()) {
                        maze.getPosition(x, y - 1).setVisited(true);
                        maze.getPosition(x, y - 1).setVal(0);
                    } else {
                        maze.getPosition(x, y + 1).setVisited(true);
                        maze.getPosition(x, y + 1).setVal(0);
                    }
                }
            }
            ArrayList<Position> tempArr = maze.getNeighborhood(t, 2);
            for (Position p : tempArr) {
                if (!p.isVisited())
                    positionQueue.add(p);
                else
                    p.setPrev(null);
            }
        }
        maze.getPosition(row - 2, col - 1).setVal(0);
        maze.getPosition(row - 1, col - 2).setVal(0);
        maze.getPosition(row - 1, col - 1).setVal(0);

        return maze;
    }


}
