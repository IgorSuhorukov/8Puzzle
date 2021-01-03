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

        if (initial.isGoal()) {
            this.solvable = true;
            return;
        }

        Board board = initial;
        Board previousBoard = board;
        Board twinBoard = initial.twin();
        Board previousTwinBoard = twinBoard;
        this.boardSequence.add(board);

        while (true) {
            MinPQ<Board> minPQ = new MinPQ<>(new BoardComparator());
            MinPQ<Board> twinMinPQ = new MinPQ<>(new BoardComparator());

            for (Board neighbor : board.neighbors()) {
                if (board.equals(neighbor) || previousBoard.equals(neighbor)) {
                    continue;
                }
                minPQ.insert(neighbor);
            }

            for (Board twinNeighbor : twinBoard.neighbors()) {
                if (twinBoard.equals(twinNeighbor) || previousTwinBoard.equals(twinNeighbor)) {
                    continue;
                }
                twinMinPQ.insert(twinNeighbor);
            }

            if (minPQ.size() > 0) {
                previousBoard = board;
                board = minPQ.delMin();
            }
            if (twinMinPQ.size() > 0) {
                previousTwinBoard = twinBoard;
                twinBoard = twinMinPQ.delMin();
            }

            this.boardSequence.add(board);
            this.move++;

            if (board.isGoal()) {
                this.solvable = true;
                break;
            }
            if (twinBoard.isGoal()) {
                this.solvable = false;
                break;
            }
        }
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

    private class BoardComparator implements Comparator<Board> {
        @Override
        public int compare(Board o1, Board o2) {
            return Integer.compare(manhattanPriority(o1), manhattanPriority(o2));
        }

        private int manhattanPriority(Board board) {
            return board.manhattan() + moves();
        }
    }
}
