import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolverMovesTest {
    @Test()
    public void testMoves1() {
        Board board = new Board(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 0},
        });
        Solver solver = new Solver(board);
        assertEquals(0, solver.moves());
    }

    @Test()
    public void testMoves2() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {0, 7, 6},
                {5, 4, 8},
        });
        Solver solver = new Solver(board);
        assertEquals(7, solver.moves());
    }

    @Test()
    public void testMoves3() {
        Board board = new Board(new int[][]{
                {2, 3, 5},
                {1, 0, 4},
                {7, 8, 6},
        });
        Solver solver = new Solver(board);
        assertEquals(8, solver.moves());
    }

    @Test()
    public void testMoves4() {
        Board board = new Board(new int[][]{
                {1, 2, 3, 4, 5},
                {12, 6, 8, 9, 10},
                {0, 7, 13, 19, 14},
                {11, 16, 17, 18, 15},
                {21, 22, 23, 24, 20},
        });
        Solver solver = new Solver(board);
        assertEquals(12, solver.moves());
    }

    @Test()
    public void testMoves5() {
        Board board = new Board(new int[][]{
                {1, 0, 2},
                {7, 5, 4},
                {8, 6, 3},
        });
        Solver solver = new Solver(board);
        assertEquals(11, solver.moves());
    }

    @Test
    public void testMoves6() {
        /*
         * puzzle07.txt
         *     - moves() returns wrong value
         *     - student   moves() = 8
         *     - reference moves() = 7 <<<<<<
         *     - initial board =
         *         3
         *          1  2  3
         *          0  7  6
         *          5  4  8
         */
        Board board = new Board(new int[][]{
                {1,  2,  3},
                {0,  7,  6},
                {5,  4,  8},
        });
        Solver solver = new Solver(board);
        assertEquals(7, solver.moves());
    }

    @Test
    public void testMoves7() {
        /*
         * puzzle08.txt
         *     - moves() returns wrong value
         *     - student   moves() = 9
         *     - reference moves() = 8 <<<<<<
         *     - initial board =
         *         3
         *          2  3  5
         *          1  0  4
         *          7  8  6
         */
        Board board = new Board(new int[][]{
                {2,  3,  5},
                {1,  0,  4},
                {7,  8,  6},
        });
        Solver solver = new Solver(board);
        assertEquals(8, solver.moves());
    }

    @Test
    public void testMoves9() {
        /*
         * puzzle11.txt
         *     - moves() returns wrong value
         *     - student   moves() = 151
         *     - reference moves() = 11 <<<<<<
         *     - initial board =
         *         3
         *          1  0  2
         *          7  5  4
         *          8  6  3
         */
        Board board = new Board(new int[][]{
                {1, 0, 2,},
                {7, 5, 4,},
                {8, 6, 3,},
        });
        Solver solver = new Solver(board);
        assertEquals(11, solver.moves());
    }

    @Test
    public void testMoves10() {
        /*
         * puzzle12.txt
         *     - moves() returns wrong value
         *     - student   moves() = 133
         *     - reference moves() = 12 <<<<<<
         *     - initial board =
         *         5
         *          1  2  3  4  5
         *         12  6  8  9 10
         *          0  7 13 19 14
         *         11 16 17 18 15
         *         21 22 23 24 20
         */
        Board board = new Board(new int[][]{
                {1,  2,  3,  4,  5},
                {12,  6,  8,  9, 10},
                {0,  7, 13, 19, 14},
                {11, 16, 17, 18, 15},
                {21, 22, 23, 24, 20},
        });
        Solver solver = new Solver(board);
        assertEquals(12, solver.moves());
    }
}
