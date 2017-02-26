package uk.gov.dwp.maze;

public class Maze {

    private int row;
    private int coulumn;
    private int height;
    private int width;
    private MazeStatus status;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCoulumn() {
        return coulumn;
    }

    public void setCoulumn(int coulumn) {
        this.coulumn = coulumn;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public MazeStatus getStatus() {
        return status;
    }

    public void setStatus(MazeStatus status) {
        this.status = status;
    }
}
