package uk.gov.dwp.maze;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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

        mazeRows.forEach( r -> {
            if(r.length() != width){
                throw new IllegalArgumentException(" Length of row " + r + " is wrong.");
            }
        });



        return null;
    }
}
