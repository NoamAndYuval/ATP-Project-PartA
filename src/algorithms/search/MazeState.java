package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    Position myPos;


    public MazeState(Position myPos) {
        this.myPos = myPos;
    }

    @Override
    public String toString() {
        return myPos.toString();
    }

}
