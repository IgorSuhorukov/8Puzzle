import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BoardNeighborsTest {
    private final int[][] orderedBoardOne = new int[][]{{1}};
    private final int[][] orderedBoardTwo = new int[][]{{1, 2}, {3, 0}};
    private final int[][] orderedBoardThree = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    private final int[][] orderedBoardFifteen = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,},
            {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,},
            {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75,},
            {76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,},
            {91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105,},
            {106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120,},
            {121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135,},
            {136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150,},
            {151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165,},
            {166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180,},
            {181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195,},
            {196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210,},
            {211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 0,},
    };

    @Test
    public void testNeighbors() {
        Board board = new Board(this.orderedBoardTwo);

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("2\n1 0 \n3 2 \n", boardIterator.next().toString());
        assertEquals("2\n1 2 \n0 3 \n", boardIterator.next().toString());
    }

    /**
     *     1  2  3
     *     4  5  6
     *     7  8  0
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors2() {
        Board board = new Board(this.orderedBoardThree);

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 2 3 \n4 5 0 \n7 8 6 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n7 0 8 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     1  2  3
     *     4  5  6
     *     0  8  7
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors3() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {0, 8, 7}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 2 3 \n0 5 6 \n4 8 7 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n8 0 7 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     0  2  3
     *     4  5  6
     *     1  8  7
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors4() {
        Board board = new Board(new int[][]{{0, 2, 3}, {4, 5, 6}, {1, 8, 7}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n2 0 3 \n4 5 6 \n1 8 7 \n", boardIterator.next().toString());
        assertEquals("3\n4 2 3 \n0 5 6 \n1 8 7 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     3  2  0
     *     4  5  6
     *     1  8  7
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors5() {
        Board board = new Board(new int[][]{{3, 2, 0}, {4, 5, 6}, {1, 8, 7}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n3 2 6 \n4 5 0 \n1 8 7 \n", boardIterator.next().toString());
        assertEquals("3\n3 0 2 \n4 5 6 \n1 8 7 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     1  2  3
     *     4  5  6
     *     7  0  8
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors6() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 2 3 \n4 0 6 \n7 5 8 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n7 8 0 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n4 5 6 \n0 7 8 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     1  2  3
     *     0  5  6
     *     7  8  4
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors7() {
        Board board = new Board(new int[][]{{1, 2, 3}, {0, 5, 6}, {7, 8, 4}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n0 2 3 \n1 5 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n5 0 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 2 3 \n7 5 6 \n0 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     1  0  3
     *     2  5  6
     *     7  8  4
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors8() {
        Board board = new Board(new int[][]{{1, 0, 3}, {2, 5, 6}, {7, 8, 4}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 3 0 \n2 5 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 5 3 \n2 0 6 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n0 1 3 \n2 5 6 \n7 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     1  6  3
     *     2  5  0
     *     7  8  4
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors9() {
        Board board = new Board(new int[][]{{1, 6, 3}, {2, 5, 0}, {7, 8, 4}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 6 0 \n2 5 3 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 5 4 \n7 8 0 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 0 5 \n7 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }

    /**
     *     1  6  3
     *     2  0  5
     *     7  8  4
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNeighbors10() {
        Board board = new Board(new int[][]{{1, 6, 3}, {2, 0, 5}, {7, 8, 4}});

        Iterator<Board> boardIterator = board.neighbors().iterator();
        assertEquals("3\n1 0 3 \n2 6 5 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 5 0 \n7 8 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n2 8 5 \n7 0 4 \n", boardIterator.next().toString());
        assertEquals("3\n1 6 3 \n0 2 5 \n7 8 4 \n", boardIterator.next().toString());
        boardIterator.next();
    }
}
