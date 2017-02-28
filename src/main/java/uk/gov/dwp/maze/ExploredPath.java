package uk.gov.dwp.maze;

import java.util.Stack;

/**
 * Created by jchondig on 27/02/2017.
 */
public class ExploredPath {
    private Stack<MazeLocation> paths;

    public ExploredPath() {
        paths = new Stack<MazeLocation>();
    }

    /**
     * Going through explored location when reach exit.
     */
    public MazeLocation getPreviousExploredLoction() {
        if (!paths.isEmpty())
            paths.pop();
        return paths.isEmpty() ? null : paths.pop();
    }

    public void addPath(MazeLocation mazeLocation) {
        paths.push(mazeLocation);
    }

    public boolean isOnPath(MazeLocation mazeLocation) {
        return paths.contains(mazeLocation);
    }

}
