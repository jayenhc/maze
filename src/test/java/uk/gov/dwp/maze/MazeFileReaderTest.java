package uk.gov.dwp.maze;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeFileReaderTest {

    private MazeFileReader mazeFileReader;

    @Test(expected = IllegalArgumentException.class)
    public void testNullFilePath() {
        this.mazeFileReader = new MazeFileReader(null);
    }

    @Test(expected  =IllegalStateException.class)
    public void testFileNotExist() {
        this.mazeFileReader = new MazeFileReader("abc.txt");
    }

    @Test
    public void testShouldReturnFile() {
        this.mazeFileReader = new MazeFileReader("/Maze1.txt");
        assertNotNull(this.mazeFileReader.getRows());
    }

}
