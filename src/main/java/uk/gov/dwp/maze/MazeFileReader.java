package uk.gov.dwp.maze;

import java.io.File;

/**
 * Created by jchondig on 25/02/2017.
 */
public class MazeFileReader {

    private File file;

    public MazeFileReader(String filePath) {
        try {
            this.file = new File(filePath);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
    }

    public File getFile() {
        return file;
    }
}
