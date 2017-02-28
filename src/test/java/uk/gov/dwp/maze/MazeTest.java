package uk.gov.dwp.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by jchondig on 27/02/2017.
 */
public class MazeTest {

    private Maze maze;
    private MazeBuilder mazeBuilder;

    @Before
    public void before() {
        this.mazeBuilder = new MazeBuilder();
        this.maze = mazeBuilder.build("/Maze.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullMazeLocation(){
        new Maze(null);
    }

    @Test()
    public void testMazeCreation(){
        assertNotNull(maze);
        assertEquals(15, maze.getHeight());
        assertEquals(15, maze.getWidth());
    }

    @Test
    public void  testInvalidMazeLoction(){
        assertNull(maze.getMazeLocation(50,50));
    }

    @Test
    public void testGetMazeLoction(){
        assertTrue(maze.getMazeLocation(0,0).isWall());
        assertFalse(maze.getMazeLocation(0,0).isStart());
        assertTrue(maze.getMazeLocation(3,3).isStart());
        assertTrue(maze.getMazeLocation(14,1).isExit());
    }

    @Test
    public void testGetNextLoction(){
        //next is north loction
        Optional<MazeLocation> nextLoction =maze.getNextMove(maze,3,3);
        Assert.assertEquals(3, nextLoction.get().getRow());
        Assert.assertEquals(4, nextLoction.get().getColumn());
    }

    @Test
    public void testExploreTurn(){
        Assert.assertEquals(false,  maze.turn(3,3));
        Assert.assertEquals(true,  maze.turn(14,1));
        Assert.assertNotNull(maze.getPreviousExplored());
    }



}