import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardManhattanTest {
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
    public void testManhattan() {
        Board board = new Board(this.orderedBoardTwo);
        assertEquals(0, board.manhattan());
    }

    @Test
    public void testManhattan1() {
        Board board = new Board(this.orderedBoardThree);
        assertEquals(0, board.manhattan());
    }

    @Test
    public void testManhattan2() {
        Board board = new Board(this.orderedBoardFifteen);
        assertEquals(0, board.manhattan());
    }

    @Test
    public void testManhattan3() {
        Board board = new Board(new int[][]{{2, 1}, {3, 0}});
        assertEquals(2, board.manhattan());
    }

    @Test
    public void testManhattan4() {
        Board board = new Board(new int[][]{{2, 1}, {0, 3}});
        assertEquals(3, board.manhattan());
    }

    @Test
    public void testManhattan5() {
        Board board = new Board(new int[][]{{3, 1}, {2, 0}});
        assertEquals(4, board.manhattan());
    }

    @Test
    public void testManhattan6() {
        Board board = new Board(new int[][]{{1, 3}, {2, 0}});
        assertEquals(4, board.manhattan());
    }

    @Test
    public void testManhattan7() {
        Board board = new Board(new int[][]{{1, 0}, {2, 3}});
        assertEquals(3, board.manhattan());
    }

    @Test
    public void testManhattan8() {
        Board board = new Board(new int[][]{{0, 3}, {2, 1}});
        assertEquals(8, board.manhattan());
    }

    @Test
    public void testManhattan9() {
        Board board = new Board(new int[][]{
                {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,},
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
                {211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 1,},
        });
        assertEquals(28, board.manhattan());
    }

    @Test
    public void testManhattan10() {
        Board board = new Board(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,},
                {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,},
                {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75,},
                {76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105,},
                {106, 107, 108, 109, 110, 111, 0, 113, 114, 115, 116, 117, 118, 119, 120,},
                {121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135,},
                {136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150,},
                {151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165,},
                {166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180,},
                {181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195,},
                {196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210,},
                {211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 112,},
        });
        assertEquals(15, board.manhattan());
    }

    @Test
    public void testManhattan11() {
        Board board = new Board(new int[][]{
            {2,   1,   3,   4,   5,   6,   7,   8,   9,   10,  11,  12,  13,  14,  15,},
            {16,  17,  18,  19,  20,  21,  22,  23,  24,  25,  26,  27,  28,  29,  30,},
            {31,  32,  33,  34,  35,  36,  37,  38,  39,  40,  41,  42,  43,  44,  45,},
            {46,  47,  48,  49,  50,  51,  52,  53,  54,  55,  56,  57,  58,  59,  60,},
            {61,  62,  63,  64,  65,  66,  67,  68,  69,  70,  71,  72,  73,  74,  75,},
            {76,  77,  78,  79,  80,  81,  82,  83,  84,  85,  86,  87,  88,  89,  90,},
            {91,  92,  93,  94,  95,  96,  97,  98,  99,  100, 101, 102, 103, 104, 105,},
            {106, 107, 108, 109, 110, 111, 0,   113, 114, 115, 160, 117, 118, 119, 120,},
            {121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135,},
            {136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150,},
            {151, 152, 153, 154, 155, 156, 157, 158, 159, 116, 161, 162, 163, 164, 165,},
            {166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180,},
            {181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195,},
            {196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210,},
            {211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 112,},
        });
        assertEquals(25, board.manhattan());
    }

    @Test
    public void testManhattan12() {
        Board board = new Board(new int[][]{
            {2,   1,   3,   4,   5,   6,   7,   8,   9,   10,  11,  169, 13,  14,  15,},
            {16,  17,  18,  19,  20,  21,  22,  23,  24,  25,  26,  27,  28,  29,  30,},
            {31,  32,  33,  34,  35,  36,  37,  38,  39,  40,  41,  42,  43,  84,  45,},
            {46,  47,  48,  49,  192, 51,  52,  53,  54,  55,  56,  57,  58,  59,  60,},
            {61,  62,  63,  64,  65,  66,  67,  68,  69,  70,  71,  72,  73,  74,  75,},
            {76,  77,  78,  79,  80,  81,  82,  83,  121,  85,  86,  87,  88, 89,  90,},
            {91,  92,  93,  94,  95,  96,  97,  98,  99,  100, 101, 102, 103, 104, 105,},
            {106, 107, 108, 109, 110, 111, 0,   113, 114, 115, 160, 117, 118, 119, 120,},
            {200, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135,},
            {136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 44, 149, 150,},
            {151, 152, 153, 154, 155, 156, 157, 158, 159, 116, 161, 162, 163, 164, 165,},
            {166, 167, 168, 12,  170, 171, 172, 148, 174, 175, 176, 177, 178, 179, 180,},
            {181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 50,  193, 194, 195,},
            {196, 197, 198, 199, 173, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210,},
            {211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 112,},
        });
        assertEquals(143, board.manhattan());
        // 121 -> 84 -> 44 -> 148 -> 173 -> 200 = 48
    }
}
