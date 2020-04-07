/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.humbug.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jj
 */
public class DirectionTest {

    /**
     * Test of opposite method, of class Direction.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        Direction instance = Direction.EAST;
        Direction expResult = Direction.WEST;
        Direction result = instance.opposite();
        assertEquals(expResult, result);

    }

}
