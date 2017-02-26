package uk.gov.dwp.maze;

/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeLocation {
    private int row;
    private int column;
    //char stored at location
    private MazeStatus status;


    public MazeLocation(int row, int column, MazeStatus status) {
        this.row = row;
        this.column = column;
        this.status = status;
    }

    public MazeLocation(int row, int column, char sign) {
        this.row = row;
        this.column = column;
        this.status = MazeStatus.getMazeStatus(sign);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public MazeStatus getStatus() {
        return status;
    }

    public void setStatus(MazeStatus status) {
        this.status = status;
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
