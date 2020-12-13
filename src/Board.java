public class Board {
    private final int[][] tiles;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles.length < 2) {
            throw new IllegalArgumentException();
        }

        this.tiles = tiles;
    }

    // string representation of this board
    public String toString() {
        String tilesString = this.tiles.length + "\n";

        for (int[] row : this.tiles) {
            for (int number : row) {
                tilesString += number + " ";
            }
            tilesString += "\n";
        }
        return tilesString;
    }

    // board dimension n
    public int dimension() {
        return -1;
    }

    // number of tiles out of place
    public int hamming() {
        int count = 0;
        int tilesLength = this.tiles.length;

        for (int i = 0; i < tilesLength; i++) {
            int[] row = this.tiles[i];
            int rowLength = row.length;

            for (int j = 0; j < rowLength; j++) {
                if (this.tiles[i][j] == (i * rowLength + j + 1) || this.tiles[i][j] == 0) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;
        int tilesLength = this.tiles.length;

        for (int i = 0; i < tilesLength; i++) {
            int[] row = this.tiles[i];
            int rowLength = row.length;

            for (int j = 0; j < rowLength; j++) {
                int current = this.tiles[i][j];
                if (current == (i * rowLength + j + 1) || current == 0) {
                    continue;
                }
                int correctRow = (int) Math.ceil((double) current / tilesLength) - 1;
                int correctColumn = current - correctRow * tilesLength - 1;
                distance += Math.abs(i - correctRow) + Math.abs(j - correctColumn);
            }
        }
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
//    public Iterable<Board> neighbors() {
//
//    }

    // a board that is obtained by exchanging any pair of tiles
//    public Board twin() {
//
//    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }

    private String generateStructureOfNItems(int n) {
        String test = "";
        for (int i = 0; i < n; i++) {
            test += "{";
            for (int j = 0; j < n; j++) {
                int number = i * n + j +1;
                test += number + ", ";
            }
            test += "},\n";
        }
        return test;
    }
}
