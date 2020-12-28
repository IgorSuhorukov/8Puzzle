import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class BoardNeighborsTest {
    private final int[][] orderedBoard = new int[][]{{1, 2}, {3, 0}};
    private final int[][] orderedBoardTwo = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    @Test
    public void testNeighbors() {
        Board board = new Board(this.orderedBoard);

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("2\n1 0 \n3 2 \n", boardIterator.next().toString());
        assertEquals("2\n1 2 \n0 3 \n", boardIterator.next().toString());
    }

    /**
     * 1  2  3
     * 4  5  6
     * 7  8  0
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors2() {
        Board board = new Board(this.orderedBoardTwo);

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 2 3 \n4 5 0 \n7 8 6 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n7 0 8 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  2  3
     * 4  5  6
     * 0  8  7
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors3() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {0, 8, 7}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 2 3 \n0 5 6 \n4 8 7 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n8 0 7 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 0  2  3
     * 4  5  6
     * 1  8  7
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors4() {
        Board board = new Board(new int[][]{
                {0, 2, 3},
                {4, 5, 6},
                {1, 8, 7}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n2 0 3 \n4 5 6 \n1 8 7 \n", boardIterator.next().toString());
        assertEquals("3\n4 2 3 \n0 5 6 \n1 8 7 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 3  2  0
     * 4  5  6
     * 1  8  7
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors5() {
        Board board = new Board(new int[][]{{3, 2, 0}, {4, 5, 6}, {1, 8, 7}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n3 2 6 \n4 5 0 \n1 8 7 \n", boardIterator.next().toString());
        assertEquals("3\n3 0 2 \n4 5 6 \n1 8 7 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  2  3
     * 4  5  6
     * 7  0  8
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors6() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 8}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 2 3 \n4 0 6 \n7 5 8 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n7 8 0 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n0 7 8 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  2  3
     * 0  5  6
     * 7  8  4
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors7() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {0, 5, 6},
                {7, 8, 4}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n0 2 3 \n1 5 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n5 0 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n7 5 6 \n0 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  0  3
     * 2  5  6
     * 7  8  4
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors8() {
        Board board = new Board(new int[][]{
                {1, 0, 3},
                {2, 5, 6},
                {7, 8, 4}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 3 0 \n2 5 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 5 3 \n2 0 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n0 1 3 \n2 5 6 \n7 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  6  3
     * 2  5  0
     * 7  8  4
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors9() {
        Board board = new Board(new int[][]{
                {1, 6, 3},
                {2, 5, 0},
                {7, 8, 4}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 6 0 \n2 5 3 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 5 4 \n7 8 0 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 0 5 \n7 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  6  3
     * 2  0  5
     * 7  8  4
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors10() {
        Board board = new Board(new int[][]{
                {1, 6, 3},
                {2, 0, 5},
                {7, 8, 4}
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 0 3 \n2 6 5 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 5 0 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 8 5 \n7 0 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n0 2 5 \n7 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     * 1  6  3
     * 2  0  5
     * 7  8  4
     */
    @Test(expected = NoSuchElementException.class)
    public void testNeighbors11() {
        Board board = new Board(new int[][]{
                { 1,  2,  3,  4,  5,},
                {16, 17, 18, 19, 20,},
                {31, 32,  0, 34, 35,},
                {46, 47, 48, 49, 50,},
                {61, 62, 63, 64, 65,},
        });

        Iterator<Board> boardIterator = board.neighbors().iterator();

        String expectedNeighbour =
                "5" +
                "\n1 2 3 4 5 \n" +
                "16 17 0 19 20 \n" +
                "31 32 18 34 35 \n" +
                "46 47 48 49 50 \n" +
                "61 62 63 64 65 \n";
        assertEquals(expectedNeighbour, boardIterator.next().toString());

        expectedNeighbour =
                "5" +
                "\n1 2 3 4 5 \n" +
                "16 17 18 19 20 \n" +
                "31 32 34 0 35 \n" +
                "46 47 48 49 50 \n" +
                "61 62 63 64 65 \n";
        assertEquals(expectedNeighbour, boardIterator.next().toString());

        expectedNeighbour =
                "5" +
                "\n1 2 3 4 5 \n" +
                "16 17 18 19 20 \n" +
                "31 32 48 34 35 \n" +
                "46 47 0 49 50 \n" +
                "61 62 63 64 65 \n";
        assertEquals(expectedNeighbour, boardIterator.next().toString());

        expectedNeighbour =
                "5" +
                "\n1 2 3 4 5 \n" +
                "16 17 18 19 20 \n" +
                "31 0 32 34 35 \n" +
                "46 47 48 49 50 \n" +
                "61 62 63 64 65 \n";
        assertEquals(expectedNeighbour, boardIterator.next().toString());

        boardIterator.next();
    }
}
