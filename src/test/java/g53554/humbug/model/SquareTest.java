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
public class SquareTest {

    /**
     * Test of hasWall method, of class Square.
     */
    @Test
    public void testHasWall_false() {
        System.out.println("hasWall false");
        Direction direction = Direction.EAST;
        Square instance = new Square(SquareType.GRASS);
        boolean expResult = false;
        boolean result = instance.hasWall(direction);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasWall method, of class Square.
     */
    @Test
    public void testHasWall() {
        System.out.println("hasWall");
        Direction direction = Direction.EAST;
        Square instance = new Square(SquareType.GRASS);
        instance.setEastWall(true);
        boolean expResult = true;
        boolean result = instance.hasWall(direction);
        assertEquals(expResult, result);

    }

}
