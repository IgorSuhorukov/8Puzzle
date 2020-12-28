import org.junit.Test;

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
}
