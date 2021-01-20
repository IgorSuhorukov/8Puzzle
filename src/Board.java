import java.util.ArrayList;

public class Board {
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final String TOP = "TOP";
    private static final String BOTTOM = "BOTTOM";

    private final int[][] tiles;
    private int moveNumber = 0;
    private int[] zeroPosition;
    private int tilesOutOfPlace = 0;
    private int distancesBetweenTilesAndGoal = 0;
    private Board twinBoard;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles.length < 2) {
            throw new IllegalArgumentException();
        }

        this.tiles = this.copy(tiles);
        this.setData();
    }

    private Board(int[][] tiles, int moveNum) {
        if (tiles.length < 2) {
            throw new IllegalArgumentException();
        }

        this.moveNumber = moveNum;
        this.tiles = this.copy(tiles);
        this.setData();
    }

    // string representation of this board
    public String toString() {
        StringBuilder tilesString = new StringBuilder(this.tiles.length + "\n");

        for (int[] row : this.tiles) {
            for (int number : row) {
                tilesString.append(number).append(" ");
            }
            tilesString.append("\n");
        }
        return tilesString.toString();
    }

    // board dimension n
    public int dimension() {
        return this.tiles.length;
    }

    // number of tiles out of place
    public int hamming() {
        return this.tilesOutOfPlace;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return this.distancesBetweenTilesAndGoal;
    }

    private void setData() {
        int tilesLength = this.tiles.length;

        for (int i = 0; i < tilesLength; i++) {
            int[] row = this.tiles[i];
            int rowLength = row.length;

            for (int j = 0; j < rowLength; j++) {
                int current = this.tiles[i][j];
                if (current == (i * rowLength + j + 1)) {
                    continue;
                }
                if (current == 0) {
                    this.zeroPosition = new int[]{i, j};
                    continue;
                }
                this.tilesOutOfPlace++;
                int correctRow = (int) Math.ceil((double) current / tilesLength) - 1;
                int correctColumn = current - correctRow * tilesLength - 1;
                this.distancesBetweenTilesAndGoal += Math.abs(i - correctRow) + Math.abs(j - correctColumn);
            }
        }
    }

    // is this board the goal board?
    public boolean isGoal() {
        return this.hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this == y) return true;
        if (y == null) return false;
        if (getClass() != y.getClass()) return false;

        Board board = (Board) y;
        if (this.dimension() != board.dimension() ||
                this.manhattan() != board.manhattan() ||
                this.hamming() != board.hamming()) {
            return false;
        }
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles.length; j++) {
                if (this.tiles[i][j] != ((Board) y).tiles[i][j]) {
                    return false;
                }
            }

        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> boardList = new ArrayList<>();
        int[] positionOfZero = getPositionOfZero();
        int row = positionOfZero[0];
        int column = positionOfZero[1];
        String[] sides = this.getAllowedNeighbourSides();

        for (String side : sides) {
            int[][] newTiles = copy(this.tiles);
            int number;
            switch (side) {
                case TOP:
                    number = newTiles[row - 1][column];
                    newTiles[row - 1][column] = 0;
                    break;
                case RIGHT:
                    number = newTiles[row][column + 1];
                    newTiles[row][column + 1] = 0;
                    break;
                case BOTTOM:
                    number = newTiles[row + 1][column];
                    newTiles[row + 1][column] = 0;
                    break;
                case LEFT:
                    number = newTiles[row][column - 1];
                    newTiles[row][column - 1] = 0;
                    break;
                default:
                    throw new IllegalArgumentException("Side is not defined.");
            }

            newTiles[row][column] = number;
            Board newBoard = new Board(newTiles, this.moveNumber + 1);

            boardList.add(newBoard);
        }

        return boardList;
    }

    private String[] getAllowedNeighbourSides() {
        int[] positionOfZero = this.getPositionOfZero();
        int row = positionOfZero[0];
        int column = positionOfZero[1];
        ArrayList<String> sides = new ArrayList<>();

        if (this.isWithinRange(row - 1)) {
            sides.add(TOP);
        }
        if (this.isWithinRange(column + 1)) {
            sides.add(RIGHT);
        }
        if (this.isWithinRange(row + 1)) {
            sides.add(BOTTOM);
        }
        if (this.isWithinRange(column - 1)) {
            sides.add(LEFT);
        }
        return sides.toArray(new String[0]);
    }

    private boolean isWithinRange(int number) {
        return 0 <= number && number < this.tiles.length;
    }

    private int[] getPositionOfZero() {
        if (this.zeroPosition != null) {
            return this.zeroPosition;
        }

        int dimension = this.dimension();
        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                if (this.tiles[row][column] == 0) {
                    this.zeroPosition = new int[]{row, column};
                    break;
                }
            }
            if (this.zeroPosition != null) {
                break;
            }
        }

        return this.zeroPosition;
    }

    private int[][] copy(int[][] originalTiles) {
        int[][] newTiles = new int[originalTiles.length][originalTiles.length];
        for (int i = 0; i < originalTiles.length; i++) {
            for (int j = 0; j < originalTiles.length; j++) {
                newTiles[i][j] = originalTiles[i][j];
            }
        }
        return newTiles;
    }

    public Board twin() {
        if (this.twinBoard != null) {
            return this.twinBoard;
        }

        int oldRow = 0;
        int oldColumn = 0;
        int oldNumber = this.tiles[oldRow][oldColumn];

        if (oldNumber == 0) {
            oldColumn = oldColumn + 1;
            oldNumber = this.tiles[oldRow][oldColumn];
        }

        int[][] newTiles = this.copy(this.tiles);

        int newRow = this.tiles.length - 1;
        int newColumn = this.tiles.length - 1;
        int newNumber = newTiles[newRow][newColumn];

        if (newNumber == 0) {
            newColumn = newColumn - 1;
            newNumber = newTiles[newRow][newColumn];
        }

        newTiles[oldRow][oldColumn] = newNumber;
        newTiles[newRow][newColumn] = oldNumber;

        this.twinBoard = new Board(newTiles);
        return this.twinBoard;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        Board board = new Board(new int[][]{{1, 2}, {3, 0}});
        Board boardTwo = new Board(new int[][]{{1, 2}, {3, 0}});

        System.out.println("should output text: " + board.toString());
        System.out.println("hamming should be: " + board.hamming());
        System.out.println("manhattan should be: " + board.manhattan());
        System.out.println("dimension should be: " + board.dimension());

        System.out.println("board are equal: " + board.equals(boardTwo));
    }
}
