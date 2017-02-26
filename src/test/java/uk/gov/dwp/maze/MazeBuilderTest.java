package uk.gov.dwp.maze;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeBuilderTest {

    private MazeBuilder mazeBuilder = new MazeBuilder();

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        mazeBuilder.build(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidFileInput() {
        mazeBuilder.build("abc");
    }


}