package uk.gov.dwp.maze;

import java.util.*;

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

    public MazeLocation getMazeLocation(int x, int y){
        if (!validateCoordinates(x, y)) {
            return null;
        }
        return location[x][y];
    }

    private boolean validateCoordinates(int row, int col) {
        return !(row < 0 || row >= getHeight() || col < 0 || col >= getWidth());
    }

    private List<MazeLocation> findMazeLocation(final MazeStatus status) {
        List<MazeLocation> results = new ArrayList<MazeLocation>();
        for (int i = 0 ; i < getHeight(); i ++) {
            for (int j = 0; j < getWidth(); j++) {
                MazeLocation coordinate = getMazeLocation(i, j);
                if (coordinate.getStatus() == status)
                    results.add(coordinate);
            }
        }
        return results;
    }

    public MazeLocation getStartLocation() {
        List<MazeLocation> starts = findMazeLocation(MazeStatus.START);
        return starts.isEmpty() ? null : starts.get(0);
    }

    public void markExplored(int x, int y, boolean visited) {
        explored[x][y] = visited;
    }

    public boolean isExplored(final int x, final int y) {
        return explored[x][y];
    }

    public Set<MazeLocation> getNextMove(Maze maze, final int currentRow, final int currentCol) {
        Set<MazeLocation> emptyLocation = new HashSet<MazeLocation>();

        for (int i = 0; i <= 3; i ++) {
            if (i == 0 && maze.getMazeLocation(currentRow, currentCol - 1).isNextMovePossible() &&
                    !maze.isExplored(currentRow, currentCol - 1)) {
                emptyLocation.add(maze.getMazeLocation(currentRow, currentCol - 1));
            } else if (i == 1 && maze.getMazeLocation(currentRow - 1, currentCol).isNextMovePossible() &&
                    !maze.isExplored(currentRow - 1, currentCol)) {
                emptyLocation.add(maze.getMazeLocation(currentRow - 1, currentCol));
            } else if (i == 2 && maze.getMazeLocation(currentRow + 1, currentCol).isNextMovePossible() &&
                    !maze.isExplored(currentRow + 1, currentCol)) {
                emptyLocation.add(maze.getMazeLocation(currentRow + 1, currentCol));
            } else if (i == 3 && maze.getMazeLocation(currentRow, currentCol + 1).isNextMovePossible() &&
                    !maze.isExplored(currentRow, currentCol + 1)) {
                emptyLocation.add(maze.getMazeLocation(currentRow, currentCol + 1));
            }
        }
        return emptyLocation;
    }


    public MazeLocation turn(final int row, final int col){
        Set<MazeLocation> mazeLocations = getNextMove(this, row, col);
        // if there are more than one open mazeLocations in front randomly pick one up.
        int size = mazeLocations.size();
        if (size > 0) {
            Random generator = new Random();
            int index = generator.nextInt(size);
            return mazeLocations.toArray(new MazeLocation[size])[index];
        }
        return null;
    }
}
