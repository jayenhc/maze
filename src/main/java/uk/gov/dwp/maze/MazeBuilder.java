package uk.gov.dwp.maze;
import java.util.List;

/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeBuilder {

    public static Maze build(String fileName) {

        MazeFileReader mazeFileReader = new MazeFileReader(fileName);
        List<String> mazeRows = mazeFileReader.getRows();

        int height = mazeRows.size();
        int width =  mazeRows.get(0).length();
        int startCount = 0;
        int exitCount = 0;

        //create MazeLocation array
        MazeLocation[][] mazeLocations = new MazeLocation[height][width];

        for (int row = 0; row < height; row++) {
            if (mazeRows.get(row).length() != width) {
                throw new IllegalArgumentException(" Length of row " + (row + 1) + " is wrong ");
            }

            for (int col = 0; col < width; col++) {
                MazeLocation location = new MazeLocation(row, col, mazeRows.get(row).charAt(col));
                mazeLocations[row][col] = location;
                if (location.isStart())
                    startCount ++;
                if (location.isExit())
                    exitCount ++;
            }
        }

        if (startCount != 1 || exitCount != 1)
            throw new IllegalArgumentException("Invalid input - should have only one Start point 'S' and only one exit 'F'");

        return new Maze(mazeLocations);
    }

    public static void main(String arg[]){
        MazeBuilder.build("/Maze.txt");
    }
}
