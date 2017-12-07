package uk.gov.dwp.maze;

/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeLocation {
    private int row;
    private int column;
    //char stored at location
    private MazeStatus status;
    private ExplorerDirection direction;


    public MazeLocation(final int row,final int column,final MazeStatus status) {
        this.row = row;
        this.column = column;
        this.status = status;
    }

    public MazeLocation(final int row,final int column,final char sign) {
        this.row = row;
        this.column = column;
        this.status = MazeStatus.getMazeStatus(sign);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public MazeStatus getStatus() {
        return status;
    }

    public boolean isStart() {
        return status == MazeStatus.START;
    }

    public boolean isExit() {
        return status == MazeStatus.EXIT;
    }

    public boolean isWall() {
        return status == MazeStatus.WALL;
    }

    public boolean isNextMovePossible() {
        return status == MazeStatus.EMPTY_SPACE ||
                status == MazeStatus.START ||
                status == MazeStatus.EXIT;
    }

}
