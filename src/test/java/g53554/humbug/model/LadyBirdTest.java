/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.humbug.model;

import static g53554.humbug.model.SquareType.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author jj
 */
public class LadyBirdTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(STAR), new Square(STAR)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Ladybird(new Position(0, 1)),
            new Ladybird(new Position(2, 0)),
            new Ladybird(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class LadyBird normal move.
     */
    @Test
    public void testMove() {
        setUp();
        System.out.println("move_general");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class LadyBird move next case when final Square
     * is busy
     */
    @Test
    public void testMove_next_final_SquareBusy() {
        setUp();
        System.out.println("move next case when final Square is busy");
        Ladybird instance = (Ladybird) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 2));
        Position expResult = new Position(0, 1); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Normal move on star
     */
    @Test
    public void testMove_next_onstar() {
        setUp();
        System.out.println("move next on star");
        Ladybird instance = (Ladybird) animals[1];
        Position expResult = new Position(2, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class LadyBird he fall out .
     */
    @Test
    public void testMove_next_notinside_2() {
        setUp();
        System.out.println("move next case null");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test move when animal is present but their field isOnStar ==true;
     */
    @Test
    public void testMove_next_animalIsInside() {
        setUp();
        System.out.println("move next when animal isPresent");
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(0, 1)),
            new Grasshopper(new Position(0, 2)),};
        Ladybird instance = (Ladybird) animals[0];
        animals[1].setOnStar(true);
        animals[2].setOnStar(true);
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    /**
     * Test when animal has wall on the east
     */
    @Test
    public void test_When_animal_hasWall() {
        setUp();
        System.out.println("test_When_animal_hasWall");
        Ladybird instance = (Ladybird) animals[0];
        board.getSquares()[instance.getPositionOnBoard().
                getRow()][instance.getPositionOnBoard().
                        getColumn()].setEastWall(true);
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test when animal has wall on the opposition direction
     */
    @Test
    public void test_When_animal_hasWall_Opposite_Direction() {
        System.out.println("test_When_animal_hasWall_OppositeDirection");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(STAR), new Square(STAR)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),};
        Ladybird instance = (Ladybird) animals[0];

        board.getSquares()[instance.getPositionOnBoard().
                next(Direction.EAST).next(Direction.EAST).
                getRow()][instance.getPositionOnBoard().
                        next(Direction.EAST).next(Direction.EAST).
                        getColumn()].setWestWall(true);
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testMove_To_Square_With_Animal_With_IsOnStar_True() {
        System.out.println("The animal can be moved to "
                + "the Square where is an animal with the field IsOnStar==true");
        Square[][] squares = {{new Square(GRASS), new Square(GRASS),
            new Square(GRASS), new Square(GRASS)},
        {new Square(GRASS), new Square(GRASS), new Square(GRASS),
            new Square(GRASS)}};
        Board boards = new Board(squares);
        animals = new Animal[2];
        animals[0] = new Ladybird(new Position(0, 0));
        animals[1] = new Snail(new Position(0, 2));
        animals[1].setOnStar(true);

        Position expResult = new Position(0, 2);
        Position result = animals[0].move(boards, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

}
