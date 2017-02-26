package uk.gov.dwp.maze;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jchondig on 26/02/2017.
 */
public class TestMazeFileReader {

    private MazeFileReader mazeFileReader;

    @Test
    public void testNullFilePath() {
        try {
            this.mazeFileReader = new MazeFileReader(null);
        } catch (IllegalArgumentException io) {
            assertThat(io.getMessage(), containsString("File path cannot be null."));
        }
    }


    @Test
    public void testShouldReturnFile() {
        this.mazeFileReader = new MazeFileReader("src/test/resources/maze.txt");
        assertNotNull(this.mazeFileReader.getFile());
    }

}
