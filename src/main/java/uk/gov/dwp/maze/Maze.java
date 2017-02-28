package uk.gov.dwp.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Maze {

    private boolean done;
    private int height;
    private int width;
    //location of each char in maze
    private MazeLocation[][] location;
    // store explored locations
    private boolean[][] explored;
    // store explored location path in stack
    private ExploredPath exploredPath;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ExploredPath getExploredPath() {
        return exploredPath;
    }

    public MazeLocation[][] getLocation() {
        return location;
    }

    public boolean[][] getExplored() {
        return explored;
    }

    public Maze(final MazeLocation[][] location) {
        if (location == null)
            throw new IllegalArgumentException("Cannot have null location in Maze");
        this.location = location;
        this.height = location.length;
        this.width = location[0].length;
        this.exploredPath = new ExploredPath();
        this.explored = new boolean[height][width];
    }

    public MazeLocation getMazeLocation(final int x, final int y) {
        if (!validateCoordinates(x, y)) {
            return null;
        }
        return location[x][y];
    }

    private boolean validateCoordinates(final int row,final int col) {
        return !(row < 0 || row >= getHeight() || col < 0 || col >= getWidth());
    }

    private List<MazeLocation> findMazeLocation(final MazeStatus status) {
        List<MazeLocation> results = new ArrayList<MazeLocation>();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                MazeLocation coordinate = getMazeLocation(i, j);
                if (coordinate.getStatus() == status)
                    results.add(coordinate);
            }
        }
        return results;
    }

    public MazeLocation getStartLocation() {
        final List<MazeLocation> starts = findMazeLocation(MazeStatus.START);
        return starts.isEmpty() ? null : starts.get(0);
    }

    public void markExplored(final int x,final int y,final boolean visited) {
        explored[x][y] = visited;
        exploredPath.addPath(location[x][y]);
    }

    public boolean isExplored(final int x, final int y) {
        return explored[x][y];
    }

    public Optional<MazeLocation> getNextMove(final Maze maze, final int currentRow, final int currentCol) {
        Optional<MazeLocation> emptyLocation;

        //First start from North
        emptyLocation = findEmptyLoction(maze, currentRow-1,currentCol);

        //if not found then check South
        if(!emptyLocation.isPresent()) {
            emptyLocation = findEmptyLoction(maze, currentRow + 1, currentCol);
        }
        // Check West
        if(!emptyLocation.isPresent()) {
            emptyLocation = findEmptyLoction(maze, currentRow, currentCol - 1);
        }
        //Check East
        if(!emptyLocation.isPresent()) {
            emptyLocation = findEmptyLoction(maze, currentRow, currentCol + 1);
        }
        return emptyLocation;
    }

    private Optional<MazeLocation> findEmptyLoction(final Maze maze,final int row,final int col) {
        Optional<MazeLocation> emptyLocation = Optional.empty();
         if(maze.getMazeLocation(row, col).isNextMovePossible() && !maze.isExplored(row, col)){
             emptyLocation = Optional.of(maze.getMazeLocation(row, col));
         }
         return emptyLocation;
    }


    /**
     * turn recursively called until find the exit
     *
     * @param row
     * @param col
     * @return
     */
    public boolean turn(final int row, final int col) {
        // check current location
        MazeLocation currentLoction = getMazeLocation(row, col);
        if (currentLoction.isExit()) {
            // found the exit 'F',
            //mark explored
            this.markExplored(row, col, true);
            done = true;
            return true;
        } else {
            //mark explored
            this.markExplored(row, col, true);
            Optional<MazeLocation> nextLoction = getNextMove(this, row, col);
            if (nextLoction.isPresent()) {
                if (turn(nextLoction.get().getRow(), nextLoction.get().getColumn())) {
                    System.out.println(this.toString());
                    printExplorersPath();
                    return !done;
                }
            } else {
                // get previous explored square
                MazeLocation previousExplored = getPreviousExplored();
                if (previousExplored != null && turn(previousExplored.getRow(), previousExplored.getColumn())) {
                    return !done;
                }
            }
        }
        return false;
    }
    public MazeLocation getPreviousExplored() {
        return this.getExploredPath().getPreviousExploredLoction();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getWidth() * getHeight());
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (location[row][col].isWall()) {
                    result.append('X');
                } else if (location[row][col].isStart()) {
                    result.append('S');
                } else if (location[row][col].isExit()) {
                    result.append('F');
                } else if (explored[row][col]) {
                    result.append('-');
                } else {
                    result.append(' ');
                }
            }
            result.append('\n');
        }
        return result.toString();
    }

    /**
     * print the accumulated paths lead to the 'F' point.
     */
    public String printExplorersPath() {
        StringBuilder result = new StringBuilder(this.getWidth() * this.getHeight());
        final MazeLocation[][] mazeLocation = this.getLocation();
        for (int row = 0; row < this.getHeight(); row++) {
            for (int col = 0; col < this.getWidth(); col++) {

                if (mazeLocation[row][col].isWall()) {
                    result.append(' ');
                } else if (mazeLocation[row][col].isStart()) {
                    result.append('S');
                } else if (mazeLocation[row][col].isExit()) {
                    result.append('F');
                } else if (this.getExploredPath().isOnPath(this.getMazeLocation(row, col))) {
                    result.append('-');
                } else {
                    result.append(' ');
                }
            }
            result.append('\n');
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
