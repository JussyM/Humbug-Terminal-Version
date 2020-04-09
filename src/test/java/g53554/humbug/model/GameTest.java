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
            new Spider(new Position(0, 1))};

        instance = new Game();
    }

    /**
     * Test of animals method, of class Game.
     */
    @Test
    public void testAnimals() {
        setUp();
        System.out.println("animals");
        Game ins = new Game();
        ins.startLevel(1);
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
        Game ins = new Game();
        ins.startLevel(level);

    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Position position = null;
        Direction direction = null;
        Game ins = new Game();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ins.move(position, direction);
        });
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveNotNullSnail() {
        System.out.println("move to position");
        Position expResult = new Position(0, 1);
        Game ins = new Game();
        ins.startLevel(1);
        Position position = ins.animals()[0].getPositionOnBoard();
        Direction direction = Direction.EAST;
        ins.move(position, direction);
        assertEquals(expResult, ins.animals()[0].getPositionOnBoard());

    }

}
