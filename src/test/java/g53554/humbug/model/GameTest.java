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
        instance= new Game();
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 1)),
            new Spider(new Position(1, 2))
        };
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
        Game instance = new Game();
        Animal[] expResult = animals;
        Animal[] result = instance.animals();
        assertEquals(expResult.length, result.length
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
        System.out.println("levelIsNotOver");
        Game instance = new Game();
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
        System.out.println("levelIsOver");
        animals[0].setOnStar(true);
        animals[1].setOnStar(true);
        animals[2].setOnStar(true);
        boolean expResult = true;
        boolean result = instance.levelIsOver();
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

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveNotNull() {
        System.out.println("move to position");
        Position position = new Position(0, 0);
        Direction direction = Direction.EAST;
        Position expResult = new Position(0, 1);
        Game instance = new Game();
        instance.startLevel(1);
        instance.move(position, direction);
        System.out.println(instance.animals()[0].getPositionOnBoard().getRow());
        System.out.println(instance.animals()[0].getPositionOnBoard().getColumn());
        assertEquals(expResult, instance.animals()[0].getPositionOnBoard());

    }

}
