import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
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

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrows() {
        new Board(this.orderedBoardOne);
    }

    @Test
    public void testToString1() {
        String expectedString = "2\n1 2 \n3 0 \n";
        Board board = new Board(this.orderedBoardTwo);
        assertEquals(expectedString, board.toString());
    }

    @Test
    public void testToString2() {
        String expectedString = "3\n1 2 3 \n4 5 6 \n7 8 0 \n";
        Board board = new Board(this.orderedBoardThree);
        assertEquals(expectedString, board.toString());
    }

    @Test
    public void testToString3() {
        String expectedString = "15\n" +
                "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 \n" +
                "16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 \n" +
                "31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 \n" +
                "46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 \n" +
                "61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 \n" +
                "76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 \n" +
                "91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 \n" +
                "106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 \n" +
                "121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 \n" +
                "136 137 138 139 140 141 142 143 144 145 146 147 148 149 150 \n" +
                "151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 \n" +
                "166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 \n" +
                "181 182 183 184 185 186 187 188 189 190 191 192 193 194 195 \n" +
                "196 197 198 199 200 201 202 203 204 205 206 207 208 209 210 \n" +
                "211 212 213 214 215 216 217 218 219 220 221 222 223 224 0 \n";
        Board board = new Board(this.orderedBoardFifteen);
        assertEquals(expectedString, board.toString());
    }

    @Test
    public void testDimension() {
        Board board = new Board(this.orderedBoardTwo);
        assertEquals(2, board.dimension());

        board = new Board(this.orderedBoardThree);
        assertEquals(3, board.dimension());

        board = new Board(this.orderedBoardFifteen);
        assertEquals(15, board.dimension());
    }

    @Test
    public void testIsGoal() {
        Board board = new Board(this.orderedBoardTwo);
        assertTrue(board.isGoal());

        board = new Board(this.orderedBoardThree);
        assertTrue(board.isGoal());

        board = new Board(this.orderedBoardFifteen);
        assertTrue(board.isGoal());

        board = new Board(new int[][]{{1, 2}, {0, 3}});
        assertFalse(board.isGoal());

        board = new Board(new int[][]{{0, 2}, {3, 1}});
        assertFalse(board.isGoal());

        board = new Board(new int[][]{{0, 3}, {1, 2}});
        assertFalse(board.isGoal());

        board = new Board(new int[][]{{0, 1}, {2, 3}});
        assertFalse(board.isGoal());
    }

    @Test
    public void testEquals() {
        this.testEquality(this.orderedBoardTwo, this.orderedBoardTwo);
    }

    @Test
    public void testEquals1() {
        this.testEquality(
                new int[][]{{1, 2}, {3, 0}},
                new int[][]{{1, 2}, {3, 0}}
        );
    }

    @Test
    public void testEquals2() {
        this.testEquality(new int[][]{{2, 1}, {0, 3}},
                new int[][]{{2, 1}, {0, 3}});
    }

    @Test
    public void testEquals3() {

        this.testNonEquality(new int[][]{{2, 1}, {0, 3}},
                new int[][]{{1, 2}, {3, 0}});
    }

    @Test
    public void testEquals4() {
        this.testNonEquality(
                new int[][]{{2, 1}, {0, 3}},
                new int[][]{{1, 2}, {3, 0}}
        );
    }

    @Test
    public void testEquals5() {
        this.testNonEquality(
                new int[][]{{1, 0}, {2, 3}},
                new int[][]{{2, 0}, {3, 1}}
        );
    }

    @Test
    public void testEquals6() {
        this.testNonEquality(
                new int[][]{
                        {0, 3, 7},
                        {5, 6, 4},
                        {8, 1, 2},
                },
                new int[][]{
                        {5, 1, 7},
                        {3, 6, 2},
                        {0, 4, 8,}
                }
        );
    }

    @Test
    public void testEquals7() {
        this.testNonEquality(
                new int[][]{
                        {3, 1, 8, 11},
                        {7, 2, 10, 4},
                        {0, 12, 14, 5},
                        {15, 13, 9, 6},
                },
                new int[][]{
                        {6, 14, 2, 15},
                        {1, 0, 4, 12},
                        {10, 3, 8, 7},
                        {5, 11, 13, 9},
                }
        );
    }

    private void testEquality(int[][] tiles1, int[][] tiles2) {
        Board boardOne = new Board(tiles1);
        Board boardTwo = new Board(tiles2);
        assertEquals(boardOne, boardTwo);
    }

    private void testNonEquality(int[][] tiles1, int[][] tiles2) {
        Board boardOne = new Board(tiles1);
        Board boardTwo = new Board(tiles2);
        assertNotEquals(boardOne, boardTwo);
    }
}
