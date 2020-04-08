package g53554.humbug.model;

/**
 *
 * @author jj
 */
public class Butterfly extends Animal {

    /**
     * Butterfly constructor
     *
     * @param positionOnBoard is the butterfly position on the board
     */
    public Butterfly(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     *s
     * @param board
     * @param direction
     * @param animals
     * @return
     */

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return animalsMove(board, direction, animals);
    }

}
