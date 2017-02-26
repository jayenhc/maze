package uk.gov.dwp.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    //User Story 2
    //Given a maze the explorer should be able to drop in to the Start point (facing north)
    @Test
    public void testExplorerCanBeDroppedAtStartPoint() {
        MazeLocation start = maze.getStartLocation();
        Assert.assertEquals(3, start.getRow());
        Assert.assertEquals(3, start.getColumn());
    }



}