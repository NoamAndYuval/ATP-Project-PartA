package algorithms.mazeGenerators;

import java.util.Iterator;


public class Maze {
    private int row;
    private int col;
    private int[][] maze_matrix;

    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        maze_matrix = new int[row][col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze_matrix[i][j]);
            }
            System.out.println();
        }

    }

    public void set_val(int row, int col, int val) {
        if (row >= this.row || col >= this.col || row < 0 || col < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (val != 0 && val != 1) {
            throw new IllegalArgumentException();
        }
        maze_matrix[row][col] = val;
    }


    /*@Override
    public Iterator iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            private int idx_row = 0;
            private int idx_col = 0;

            @Override
            public boolean hasNext() {
                return idx_col + 1 < col || idx_row + 1 < row;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    return null;
                }
                if (idx_col + 1 == col) {
                    idx_col = 0;
                    idx_row++;
                } else {
                    idx_col++;
                }
                return maze_matrix[idx_row][idx_col];
            }
        };
        return it;
    }*/
}
