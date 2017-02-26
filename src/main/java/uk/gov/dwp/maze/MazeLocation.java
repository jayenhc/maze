package uk.gov.dwp.maze;

/**
 * Created by jchondig on 26/02/2017.
 */
public class MazeLocation {
    private int row;
    private int column;
    //char stored at location
    private MazeStatus status;

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
}
