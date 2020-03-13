package g53554.humbug.model;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jj
 */
public class PositionTest {

    /**
     * Test of next method, of class Position.
     */
    @org.junit.jupiter.api.Test
    public void testNext() {
        System.out.println("next");
        Direction direction = Direction.EAST;
        Position instance = new Position(0, 0);
        Position expResult = new Position(0, 1);
        Position result = instance.next(direction);
        assertEquals(expResult, result);

    }
}
