package uk.gov.dwp.maze;

/**
 * Created by jchondig on 26/02/2017.
 */
public enum MazeStatus {

    WALL,
    START,
    EXIT,
    EMPTY_SPACE,
    EXPLORED,
    UNKNOWN,

    MazeStatus(){};

    public static MazeStatus getMazeStatus(final char sign){

        if (' ' == sign)
            return MazeStatus.EMPTY_SPACE;
        else if ('X' == sign)
            return MazeStatus.WALL;
        else if ('S' == sign)
            return MazeStatus.START;
        else if ('F' == sign)
            return MazeStatus.EXIT;
        else if ('V' == sign)
            return MazeStatus.EXPLORED;
        else
            return UNKNOWN;
    }
}
