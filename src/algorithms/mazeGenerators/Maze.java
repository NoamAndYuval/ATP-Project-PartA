package algorithms.mazeGenerators;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {
    protected int row;
    protected int col;
    protected Position source;
    protected Position target;
    private Position[][] maze_matrix;

    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        maze_matrix = new Position[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze_matrix[i][j] = new Position(i, j);
            }
        }
        source = maze_matrix[0][0];
        target = maze_matrix[row - 1][col - 1];
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
                Position temp = maze_matrix[i][j];
                if (temp == source)
                    System.out.print("S");
                else if (temp == target)
                    System.out.print("E");
                else
                    System.out.print(temp.getVal());
            }
            System.out.println();
        }

    }

    public void Display() throws IOException {

        Color c;
        BufferedImage image = new BufferedImage(row/*Width*/, col/*height*/, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if((i==source.getRowIndex()&&j==source.getColumnIndex())){
                    c = new Color(0, 255, 0);
                }
                else if ((i==target.getRowIndex()&&j==target.getColumnIndex())){
                    c = new Color(255, 0, 0);

                }
                else if ((maze_matrix[i][j].getVal()==0)){
                    c = new Color(255, 255, 255);
                }
                else {
                    c = new Color(0, 0, 0);
                }
                image.setRGB(i, j, c.getRGB());
            }
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(row*20+100, col*20+100);
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 15, 15,row*7,col*7,null );
            }
        };
        pane.setSize(650,650);
        pane.setPreferredSize(new Dimension(650, 650));
        frame.add(pane,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void set_val(int row, int col, int val) {
        if (row >= this.row || col >= this.col || row < 0 || col < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (val != 0 && val != 1) {
            throw new IllegalArgumentException();
        }
        maze_matrix[row][col].setVal(val);
    }

    public Position getStartPosition() {
        return source;
    }

    public Position getGoalPosition() {
        return target;
    }

    public Position getPosition(int x, int y) {
        try {
            return maze_matrix[x][y];
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Position> getNeighborhood(Position pos, int dis) {
        ArrayList<Position> positionArrayList = new ArrayList<>();
        int x = pos.getRowIndex();
        int y = pos.getColumnIndex();
        if (x + dis < row) {
            positionArrayList.add(this.maze_matrix[x + dis][y]);
            this.maze_matrix[x + dis][y].setPrev(pos);
        }
        if (y + dis < col) {
            positionArrayList.add(this.maze_matrix[x][y + dis]);
            this.maze_matrix[x][y + dis].setPrev(pos);
        }
        if (x - dis >= 0) {
            positionArrayList.add(this.maze_matrix[x - dis][y]);
            this.maze_matrix[x - dis][y].setPrev(pos);

        }
        if (y - dis >= 0) {
            positionArrayList.add(this.maze_matrix[x][y - dis]);
            this.maze_matrix[x][y - dis].setPrev(pos);
        }
        return positionArrayList;

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
