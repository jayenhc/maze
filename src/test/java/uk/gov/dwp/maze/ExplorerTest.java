package uk.gov.dwp.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by jchondig on 26/02/2017.
 */
public class ExplorerTest {

    private Maze maze;
    private Explorer explorer;

    @Before
    public void before() {
        MazeBuilder builder = new MazeBuilder();
        maze = builder.build("/Maze.txt");
        explorer = new Explorer(maze);
    }

    @Test
    public void testExplorerCanBeDroppedAtStartPoint() {
        MazeLocation start = maze.getStartLocation();
        Assert.assertEquals(3, start.getRow());
        Assert.assertEquals(3, start.getColumn());

    }

    @Test
    public void testExplorMaze(){
        explorer.exploreMaze();
        Assert.assertNotNull(maze.getExplored());
        Assert.assertTrue(maze.isExplored(3,4));
        Assert.assertTrue(maze.getExplored().length > 0);
    }
}