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
     * Apply the move for the butterfly
     *
     * @param board of the game
     * @param direction of the butterfly
     * @param animals arrays that contain all the animals of the game
     * @return next Position
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return animalsMove(board, direction, animals);
    }

}
