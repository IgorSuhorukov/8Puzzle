import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolverTest {
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        new Solver(null);
    }

    @Test()
    public void testIsSolvable() {
        Board board = new Board(new int[][]{
                {1, 2},
                {3, 0},
        });
        Solver solver = new Solver(board);
        assertTrue(solver.isSolvable());
    }

    @Test()
    public void testIsSolvable2() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        });
        Solver solver = new Solver(board);
        assertTrue(solver.isSolvable());
    }

    @Test()
    public void testIsSolvable3() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {7, 4, 6},
                {0, 5, 8},
        });
        Solver solver = new Solver(board);
        assertTrue(solver.isSolvable());
    }


    @Test()
    public void testSolution() {
        Board board = new Board(new int[][]{{1, 0}, {3, 2}});
        Board expectedBoard = new Board(new int[][]{{1, 0}, {3, 2}});

        Solver solver = new Solver(board);
        assertEquals(expectedBoard, solver.solution().iterator().next());
    }

    @Test()
    public void testSolution2() {
        Board board = new Board(new int[][]{{1, 0}, {3, 2}});
        Board expectedBoard = new Board(new int[][]{{1, 2}, {3, 0}});

        Solver solver = new Solver(board);
        Board lastSolution = null;
        for (Board solution : solver.solution()) {
            lastSolution = solution;
        }
        assertEquals(expectedBoard, lastSolution);
    }

    @Test()
    public void testSolution3() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {0, 7, 6},
                {5, 4, 8},
        });
        Board expectedFirstBoard = new Board(new int[][]{
                {1, 2, 3},
                {0, 7, 6},
                {5, 4, 8},
        });

        Solver solver = new Solver(board);
        assertEquals(expectedFirstBoard, solver.solution().iterator().next());
    }

    @Test()
    public void testSolution4() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {0, 7, 6},
                {5, 4, 8},
        });

        Solver solver = new Solver(board);
        int amount = 0;
        for (Board solution : solver.solution()) {
            amount++;
        }
        assertEquals(8, amount);
    }
}
