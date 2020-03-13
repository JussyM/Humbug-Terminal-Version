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
public class BoardTest {

//    /**
//     * Test of getInitBoard method, of class Board.
//     */
//    @Test
//    public void testGetInitBoard() {
//        System.out.println("getInitBoard");
//        Board expResult = new Board(new Square[3][3]);
//        Board result = Board.getInitBoard();
//        assertEquals(expResult, result);
//
//    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Position position = new Position(2, 2);
        Board instance = Board.getInitBoard();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);

    }

    /**
     * Test of isNotInside method, of class Board.
     */
    @Test
    public void testIsNotInside() {
        System.out.println("isInside");
        Position position = new Position(0, 0);
        Board instance = Board.getInitBoard();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSquareType method, of class Board.
     */
    @Test
    public void testGetSquareType() {
        System.out.println("getSquareType");
        Position position = new Position(0, 0);
        Board instance = Board.getInitBoard();
        SquareType expResult = SquareType.GRASS;
        SquareType result = instance.getSquareType(position);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNbRow method, of class Board.
     */
    @Test
    public void testGetNbRow() {
        System.out.println("getNbRow");
        Board instance = Board.getInitBoard();
        int expResult = 3;
        int result = instance.getNbRow();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNbColumn method, of class Board.
     */
    @Test
    public void testGetNbColumn() {
        System.out.println("getNbColumn");
        Board instance = Board.getInitBoard();
        int expResult = 3;
        int result = instance.getNbColumn();
        assertEquals(expResult, result);

    }

}
