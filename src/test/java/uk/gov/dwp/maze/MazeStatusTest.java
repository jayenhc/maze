package uk.gov.dwp.maze;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeStatusTest {

    @Test
    public void testGetMazeStatusBySign() {
        assertEquals(MazeStatus.START, MazeStatus.getMazeStatus('S'));
        assertEquals(MazeStatus.EXIT , MazeStatus.getMazeStatus('F'));
        assertEquals(MazeStatus.WALL , MazeStatus.getMazeStatus('X'));
        assertEquals(MazeStatus.EMPTY_SPACE , MazeStatus.getMazeStatus(' '));
        assertEquals(MazeStatus.UNKNOWN ,MazeStatus.getMazeStatus('T'));
    }

}