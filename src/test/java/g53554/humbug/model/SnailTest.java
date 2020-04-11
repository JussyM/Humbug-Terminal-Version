package g53554.humbug.model;

import static g53554.humbug.model.SquareType.GRASS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static g53554.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author jj
 */
public class SnailTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(STAR), new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2)),
            new Snail(new Position(2, 0)),
            new Snail(new Position(2, 1)),
            new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        setUp();
        System.out.println("move_general");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notfree() {
        setUp();
        System.out.println("move next case not free");
        Snail instance = (Snail) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_onstar() {
        setUp();
        System.out.println("move next on star");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside_2() {
        setUp();
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testMove_next_animalIsInside() {
        setUp();
        System.out.println("move next when animal isPresent");
        Snail instance = (Snail) animals[2];
        animals[3].setOnStar(true);
        Position expResult = new Position(2, 1);
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
        Snail instance = (Snail) animals[0];
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
        setUp();
        System.out.println("test_When_animal_hasWall_OppositeDirection");
        Snail instance = (Snail) animals[0];
        board.getSquares()[instance.getPositionOnBoard().next(Direction.EAST).
                getRow()][instance.getPositionOnBoard().next(Direction.EAST).
                        getColumn()].setWestWall(true);
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

}
