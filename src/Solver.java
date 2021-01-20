import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Solver {
    private int move = 0;
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

        Node searchNode = new Node(initialBoard, 0, null);
        Node twinSearchNode = new Node(initialBoard.twin(), 0, null);

        MinPQ<Node> minPQ = new MinPQ<>();
        MinPQ<Node> twinMinPQ = new MinPQ<>();

        minPQ.insert(searchNode);
        twinMinPQ.insert(twinSearchNode);

        while (true) {
            if (searchNode.getBoard().isGoal()) {
                this.solvable = true;
                return;
            }

            if (twinSearchNode.getBoard().isGoal()) {
                this.solvable = false;
                return;
            }

            searchNode = minPQ.delMin();
            twinSearchNode = twinMinPQ.delMin();

            this.boardSequence.add(searchNode.getBoard());
            twinBoardSequence.add(twinSearchNode.getBoard());

            for (Board neighbour : searchNode.getBoard().neighbors()) {
                if (this.boardSequence.contains(neighbour)) {
                    continue;
                }
                minPQ.insert(new Node(neighbour, searchNode.getMoves() + 1, searchNode));
            }

            for (Board twinNeighbour : twinSearchNode.getBoard().neighbors()) {
                if (twinBoardSequence.contains(twinNeighbour)) {
                    continue;
                }
                twinMinPQ.insert(new Node(twinNeighbour, twinSearchNode.getMoves() + 1, twinSearchNode));
            }

            this.move++;
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

    private class Node implements Comparable<Node> {
        private final Board board;
        private final int moves;
        private final int manPriority;
        private final Node prevNode;

        public Node(Board board, int moves, Node prevNode) {
            this.board = board;
            this.moves = moves;
            this.manPriority = board.manhattan() + moves;
            this.prevNode = prevNode;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public int getManPriority() {
            return manPriority;
        }

        public int getMoves() {
            return moves;
        }

        public Board getBoard() {
            return board;
        }

        @Override
        public int compareTo(Node o) {
            return this.getManPriority() - o.getManPriority();
        }
    }

}
