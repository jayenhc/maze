package uk.gov.dwp.maze;

public class Explorer {

    private Maze maze;

    public Explorer(Maze maze) {
        this.maze = maze;
    }

    public static void main(String arg[]){
        Explorer explorer = new Explorer(MazeBuilder.build("/Maze.txt"));
        explorer.exploreMaze();
    }

    public void exploreMaze() {
        MazeLocation start = maze.getStartLocation();
        MazeLocation location= maze.turn(start.getRow(),start.getColumn());
        System.out.println(location.getRow() + " : " + location.getColumn());

    }
}
