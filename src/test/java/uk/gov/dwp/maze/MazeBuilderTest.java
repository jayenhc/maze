package uk.gov.dwp.maze;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void testMazeWithMultipleStarts() {
        try {
            mazeBuilder.build("/MultipleStarts.txt");
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains("Invalid input - should have only one Start point 'S' and only one exit 'F'"));
        }
    }

    @Test
    public void testMazeWithMultipleFinish() {
        try {
            mazeBuilder.build("/MultipleExits.txt");
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains("Invalid input - should have only one Start point 'S' and only one exit 'F'"));
        }
    }

    @Test
    public void testMazeBuild() {
        Maze maze = mazeBuilder.build("/Maze.txt");
        Assert.assertNotNull(maze);
        Assert.assertNotNull(maze.getHeight());
        Assert.assertNotNull(maze.getWidth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContentInput() {
        Maze maze = mazeBuilder.build("/InvalidMaze.txt");
    }
}