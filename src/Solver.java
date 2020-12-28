import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;

public class Solver {
    private boolean solvable = false;
    private int move = 0;
    private final ArrayList<Board> boardSequence = new ArrayList<>();

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }

        Board board = initial;
        while (!board.isGoal()) {
            Iterable<Board> neighbors = board.neighbors();
            MinPQ<Board> minPQ = new MinPQ<>(new BoardComparator());

            for (Board neighbor : neighbors) {
                if (board.equals(neighbor)) {
                    continue;
                }
                minPQ.insert(neighbor);
            }

            board = minPQ.delMin();
            this.boardSequence.add(board);
            this.move++;
        }

        this.solvable = true;
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return this.solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!this.isSolvable()) {
            return -1;
        }
        return this.move;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!this.isSolvable()) {
            return null;
        }

        return this.boardSequence;
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private int manhattanPriority(Board board) {
        return board.manhattan() + this.moves();
    }

    private class BoardComparator implements Comparator<Board> {
        @Override
        public int compare(Board o1, Board o2) {
            if (manhattanPriority(o1) == manhattanPriority(o2)) {
                return 0;
            }

            if (manhattanPriority(o1) < manhattanPriority(o2)) {
                return -1;
            }

            return 1;
        }
    }
}