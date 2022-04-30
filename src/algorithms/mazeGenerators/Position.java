package algorithms.mazeGenerators;

public class Position {
    int x;
    int y;
    int val;
    boolean visited;
    Position prev;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.visited=false;
        this.val = 0;
        this.prev = null;
    }
    public Position getPrev() {
        return prev;
    }

    public void setPrev(Position prev) {
        this.prev = prev;
    }


    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }
}
