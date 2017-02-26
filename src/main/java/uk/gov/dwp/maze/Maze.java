package uk.gov.dwp.maze;

public class Maze {

    private int height;
    private int width;
    //location of each char in maze
    private MazeLocation [][] location;
    private boolean[][] explored;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public MazeLocation[][] getLocation() {
        return location;
    }

    public void setLocation(MazeLocation[][] location) {
        this.location = location;
    }

    public boolean[][] getExplored() {
        return explored;
    }

    public void setExplored(boolean[][] explored) {
        this.explored = explored;
    }

    public Maze(final MazeLocation[][] location) {
        if (location == null)
            throw new IllegalArgumentException("Cannot have null location in Maze");
        this.location = location;
        this.height = location.length;
        this.width = location[0].length;
        this.explored = new boolean[height][width];
    }
}
