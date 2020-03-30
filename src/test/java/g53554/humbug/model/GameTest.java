package g53554.humbug.model;

import static g53554.humbug.model.SquareType.GRASS;
import static g53554.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author jj
 */
public class GameTest {

    Game instance;

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {

        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
        animals = new Animal[]{
            new Spider(new Position(0, 1)), new Snail(new Position(2, 1))};

        instance = new Game();
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        setUp();
        System.out.println("getBoard");
        Game instance = new Game();
        Board expResult = Board.getInitBoard();
        Board result = instance.getBoard();
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of animals method, of class Game.
     */
    @Test
    public void testAnimals() {
        setUp();
        System.out.println("animals");
        Game ins = new Game();
        Animal[] expResult = animals;
        Animal[] result = ins.animals();
        assertEquals(expResult.getClass(), result.getClass()
        );

    }

    /**
     * Test of startLevel method, of class Game.
     */
    @Test
    public void testStartLevel() {
        System.out.println("startLevel");
        int level = 1;
        Game instance = new Game();
        instance.startLevel(level);

    }

    /**
     * Test of levelIsOver method, of class Game.
     */
    @Test
    public void testLevelIsNotOver() {
        setUp();
        System.out.println("levelIsNotOver");
        instance.startLevel(1);
        boolean expResult = false;
        boolean result = instance.levelIsOver();
        assertEquals(expResult, result);

    }

    /**
     * Test of levelIsOver method, of class Game.
     */
    @Test
    public void testLevelIsOver() {
        setUp();
        System.out.println("levelIsOver");
        Game ins = new Game();
        ins.startLevel(0);
        ins.animals()[0].setOnStar(true);
        ins.animals()[1].setOnStar(true);
        boolean expResult = true;
        boolean result = ins.levelIsOver();
        assertEquals(expResult, result);

    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Position position = null;
        Direction direction = null;
        Game instance = new Game();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            instance.move(position, direction);
        });
    }

//    /**
//     * Test of move method, of class Game.
//     */
//    @Test
//    public void testMoveNotNullSnail() {
//        System.out.println("move to position");
//        Position expResult = new Position(0, 1);
//        Game instance = new Game();
//        instance.startLevel(1);
//        Position position = instance.animals()[0].getPositionOnBoard();
//        Direction direction = Direction.EAST;
//        instance.move(position, direction);
//        assertEquals(expResult, instance.animals()[0].getPositionOnBoard());
//
//    }
     @Test
    public void testMoveNotNullSpider() {
//        setUp();
        System.out.println("move to position");
        Position expResult = new Position(1, 1);
        Game instance = new Game();
        instance.startLevel(1);
        Position position = instance.animals()[0].getPositionOnBoard();
        Direction direction = Direction.SOUTH;
        instance.move(position, direction);
        assertEquals(expResult, instance.animals()[0].getPositionOnBoard());

    }

}
