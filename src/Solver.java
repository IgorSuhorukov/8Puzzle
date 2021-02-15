import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private final MinPQ<Node> pq;
    private final MinPQ<Node> pqTwin;
    private final Board initial;
    private final Board goal;

    private static class Node implements Comparable<Node> {
        private final Board board;
        private final int moves;
        private final int priority;
        private final Node previousNode;

        public Node(Board board, int moves, Node previousNode) {
            this.board = board;
            this.moves = moves;
            priority = moves + board.manhattan();
            this.previousNode = previousNode;
        }

        public int compareTo(Node that) {
            return (this.priority - that.priority);
        }
    }

    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();

        this.initial = initial;
        int n = initial.dimension();
        pq = new MinPQ<Node>();
        pqTwin = new MinPQ<Node>();

        int[][] blocks = new int[n][n];
        int k = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                blocks[i][j] = k;
                k++;
            }
        blocks[n - 1][n - 1] = 0;
        goal = new Board(blocks);

        Node minNode;
        Node minNodeTwin;

        pq.insert(new Node(initial, 0, null));
        pqTwin.insert(new Node(initial.twin(), 0, null));

        while (!pq.min().board.equals(goal) && !pqTwin.min().board.equals(goal)) {
            minNode = pq.min();
            minNodeTwin = pqTwin.min();

            pq.delMin();
            pqTwin.delMin();

            for (Board neighbor : minNode.board.neighbors()) {
                if (minNode.moves == 0) {
                    pq.insert(new Node(neighbor, minNode.moves + 1, minNode));
                } else if (!neighbor.equals(minNode.previousNode.board)) {
                    pq.insert(new Node(neighbor, minNode.moves + 1, minNode));
                }
            }

            for (Board neighbor : minNodeTwin.board.neighbors()) {
                if (minNodeTwin.moves == 0) {
                    pqTwin.insert(new Node(neighbor, minNodeTwin.moves + 1, minNodeTwin));
                } else if (!neighbor.equals(minNodeTwin.previousNode.board)) {
                    pqTwin.insert(new Node(neighbor, minNodeTwin.moves + 1, minNodeTwin));
                }
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        if (pq.min().board.equals(goal)) {
            return true;
        }
        if (pqTwin.min().board.equals(goal)) {
            return false;
        }
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) return -1;

        return pq.min().moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) return null;
        Stack<Board> stackSolution = new Stack<Board>();
        Node current = pq.min();
        while (current.previousNode != null) {
            stackSolution.push(current.board);
            current = current.previousNode;
        }
        stackSolution.push(initial);
        return stackSolution;
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
}
