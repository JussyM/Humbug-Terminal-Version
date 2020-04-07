package g53554.humbug.model;

/**
 *
 * @author jj
 */

public class Bumblebee extends Animal {

    /**
     *
     * @param positionOnBoard
     */
    public Bumblebee(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return null;
    }

}
