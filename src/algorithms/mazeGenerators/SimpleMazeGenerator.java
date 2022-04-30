package algorithms.mazeGenerators;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator
{

    @Override
    public Maze generate(int row, int col)
    {
        Random rand =new Random();
        Maze maze=new Maze(row,col);
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                maze.set_val(i,j, rand.nextInt(2));
            }
        }
        return maze;
    }
}
