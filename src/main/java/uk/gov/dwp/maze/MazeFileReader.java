package uk.gov.dwp.maze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jchondig on 25/02/2017.
 */
public class MazeFileReader {

    private List<String>  rows;

    public MazeFileReader(String filePath) {
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
