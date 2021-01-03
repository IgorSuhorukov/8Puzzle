import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTwinTest {
    @Test
    public void testTwin1() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        });
        String expectedString = "3\n8 2 3 \n4 5 6 \n7 1 0 \n";
        assertEquals(expectedString, board.twin().toString());
    }

    @Test
    public void testTwin2() {
        Board board = new Board(new int[][]{
                {4, 2, 8},
                {7, 1, 3},
                {6, 5, 0}
        });
        String expectedString = "3\n5 2 8 \n7 1 3 \n6 4 0 \n";
        assertEquals(expectedString, board.twin().toString());
    }

    @Test
    public void testTwin3() {
        Board board = new Board(new int[][]{
                {0, 2, 3},
                {4, 5, 6},
                {7, 8, 1}
        });
        String expectedString = "3\n0 1 3 \n4 5 6 \n7 8 2 \n";
        assertEquals(expectedString, board.twin().toString());
    }

    @Test
    public void testTwin4() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 6}
        });
        String expectedString = "3\n6 2 3 \n4 5 0 \n7 8 1 \n";
        assertEquals(expectedString, board.twin().toString());
    }
}
