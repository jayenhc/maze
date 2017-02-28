package uk.gov.dwp.maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jchondig on 25/02/2017.
 */
public class MazeFileReader {

    private List<String>  rows;

    public MazeFileReader(final String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        rows = new ArrayList<>();
        try (InputStream fileInputStream = this.getClass().getResourceAsStream(filePath)) {
            if (fileInputStream == null) {
                throw new IllegalStateException("File does not exsist : " + filePath);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))) {
                //br returns as stream and convert it into a List
                rows = br.lines().collect(Collectors.toList());
            }
        } catch ( IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }
    }

    public List<String> getRows() {
        if(rows == null){
            rows = new ArrayList<>();
        }
        return rows;
    }
}
