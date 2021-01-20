import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;

public class Solver {
    private boolean solvable;
    private int minimalMoves = 0;
    private final ArrayList<Board> boardSequence = new ArrayList<>();

    public Solver(Board initialBoard) {
        if (initialBoard == null) {
            throw new IllegalArgumentException();
        }

        if (initialBoard.isGoal()) {
            this.solvable = true;
            return;
        }

        ArrayList<Board> twinBoardSequence = new ArrayList<>();
        this.minimalMoves = initialBoard.manhattan();

        Board searchNode = initialBoard;
        Board twinSearchNode = initialBoard.twin();

        MinPQ<Board> minPQ = new MinPQ<>(new BoardComparator());
        MinPQ<Board> twinMinPQ = new MinPQ<>(new BoardComparator());

        minPQ.insert(initialBoard);
        twinMinPQ.insert(initialBoard.twin());

        this.boardSequence.add(searchNode);
        twinBoardSequence.add(twinSearchNode);

        while (true) {
            if (searchNode.isGoal()) {
                this.solvable = true;
                return;
            }

            if (twinSearchNode.isGoal() || minPQ.size() < 1) {
                this.solvable = false;
                return;
            }

            searchNode = minPQ.delMin();
            twinSearchNode = twinMinPQ.delMin();

            this.boardSequence.add(searchNode);
            twinBoardSequence.add(twinSearchNode);

            for (Board neighbour : searchNode.neighbors()) {
                if (this.boardSequence.contains(neighbour)) {
                    continue;
                }
                minPQ.insert(neighbour);
            }

            for (Board twinNeighbour : twinSearchNode.neighbors()) {
                if (twinBoardSequence.contains(twinNeighbour)) {
                    continue;
                }
                twinMinPQ.insert(twinNeighbour);
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
        return this.minimalMoves;
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
            return o1.manhattan() - o2.manhattan();
        }
    }
}
