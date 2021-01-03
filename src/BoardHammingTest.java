import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardHammingTest {
    private final int[][] orderedBoardTwo = new int[][]{{1, 2}, {3, 0}};
    private final int[][] orderedBoardThree = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    @Test
    public void testHamming2() {
        Board board = new Board(this.orderedBoardTwo);
        assertEquals(0, board.hamming());
    }

    @Test
    public void testHamming3() {
        Board board = new Board(this.orderedBoardThree);
        assertEquals(0, board.hamming());
    }

    @Test
    public void testHamming4() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});
        assertEquals(1, board.hamming());
    }

    @Test
    public void testHamming5() {
        Board board = new Board(new int[][]{{1, 3, 2}, {4, 5, 6}, {7, 8, 0}});
        assertEquals(2, board.hamming());
    }

    @Test
    public void testHamming6() {
        Board board = new Board(new int[][]{{3, 1, 2}, {4, 5, 6}, {7, 8, 0}});
        assertEquals(3, board.hamming());
    }

    @Test
    public void testHamming7() {
        Board board = new Board(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        assertEquals(8, board.hamming());
    }

    @Test
    public void testHamming8() {
        Board board = new Board(new int[][]{{8, 7, 6}, {5, 4, 3}, {2, 1, 0}});
        assertEquals(8, board.hamming());
    }

    @Test
    public void testHamming9() {
        Board board = new Board(new int[][]{
                {1, 17, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,},
                {16, 2, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,},
                {46, 47, 64, 49, 50, 51, 52, 53, 54, 55, 0, 57, 58, 59, 60,},
                {61, 62, 63, 48, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75,},
                {76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 219, 101, 102, 103, 104, 105,},
                {106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120,},
                {121, 122, 184, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135,},
                {136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150,},
                {151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165,},
                {166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180,},
                {181, 182, 183, 123, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195,},
                {196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210,},
                {211, 212, 213, 214, 215, 216, 217, 218, 100, 220, 221, 222, 223, 224, 56,},
        });
        assertEquals(9, board.hamming());
    }
}
