package g53554.humbug.model;

/**
 *
 * @author jj
 */
public class Bumbelbee extends Animal {

    /**
     * Simple constructor of bumblebee
     *
     * @param positionOnBoard bumblebee position on the board
     */
    public Bumbelbee(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     * Apply the move of the bumblebee who fly above two square and drop on the
     * third square if free on the fourth if not or return null if the position
     * is out of the board
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays that contain all the animal of the game
     * @return next Position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {

        return animalsMove(board, direction, animals);
    }

}
