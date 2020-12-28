import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BoardTwinTest {
    @Test
    public void testTwin1() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        });
        String expectedString = "3\n1 2 3 \n4 5 6 \n7 8 0 \n";
        assertNotEquals(expectedString, board.twin());
    }
}
