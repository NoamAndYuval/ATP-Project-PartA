package algorithms.mazeGenerators;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    private Position[][] positions;

    @Override
    public Maze generate(int row, int col) {
        Maze maze = new Maze(row, col);
        Position[][] positions = new Position[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                positions[i][j] = new Position(i, j);
            }
        }
        ArrayList<Position> positionQueue = new ArrayList<Position>();
        positionQueue.add(positions[0][0]);
        while (!positionQueue.isEmpty()) {
            int rd = (int) ((Math.random() * positionQueue.size()));
            Position t = positionQueue.get(rd);
            positionQueue.remove(rd);
            t.setVisited(true);
            int x = t.getX();
            int y = t.getY();
            positions[x][y].val = 1;
            if (t.getPrev() != null) {
                if (x != t.getPrev().getX()) {
                    if (x > t.getPrev().getX()) {
                        positions[x-1][y].setVisited(true);
                        positions[x-1][y].val=1;
                    }else {
                        positions[x+1][y].setVisited(true);
                        positions[x+1][y].val=1;
                    }
                }
                if (y != t.getPrev().getY()) {
                    if (y > t.getPrev().getY()) {
                        positions[x][y-1].setVisited(true);
                        positions[x][y-1].val=1;
                    }else {
                        positions[x][y+1].setVisited(true);
                        positions[x][y+1].val=1;
                    }
                }
            }
            if (x + 2 < positions.length && !positions[x + 2][y].isVisited()) {
                positionQueue.add(positions[x + 2][y]);
                positions[x + 2][y].setPrev(t);
            }
            if (y + 2 < positions[0].length && !positions[x][y + 2].isVisited()) {
                positionQueue.add(positions[x][y + 2]);
                positions[x][y + 2].setPrev(t);
            }
            if (x - 2 >= 0 && !positions[x - 2][y].isVisited()) {
                positionQueue.add(positions[x - 2][y]);
                positions[x - 2][y].setPrev(t);
            }
            if (y - 2 >= 0 && !positions[x][y - 2].isVisited()) {
                positionQueue.add(positions[x][y - 2]);
                positions[x][y - 2].setPrev(t);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze.set_val(i, j, positions[i][j].val);
            }
        }
        return maze;
    }

    private void prim_algorithm(Position p) {


    }


}
