package uk.gov.dwp.maze;

public class Explorer {

    private Maze maze;

    public Explorer(Maze maze) {
        this.maze = maze;
    }

    public static void main(String arg[]){
        final Explorer explorer = new Explorer(MazeBuilder.build("/Maze.txt"));
        explorer.exploreMaze();
    }

    public void exploreMaze() {
        final MazeLocation start = maze.getStartLocation();
        if( maze.turn(start.getRow(),start.getColumn())) {
            System.out.println(maze);
        }

    }
}
