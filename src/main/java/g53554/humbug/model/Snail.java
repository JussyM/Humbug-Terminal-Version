package g53554.humbug.model;

/**
 * This class represent the snail that move on the board and move only once
 * according to direction given an really move if the new position he is moving
 * to is free
 *
 * @author jj
 */
public class Snail extends Animal {

    /**
     * Snail simple constructor
     *
     * @param positionOnBoard
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * this method apply the move according to snail capacity return a new
     * postion if he can move return a null if he falls out and also return his
     * old position if an animal is on his new position
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return new position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return animalsMove(board, direction, animals);
    }
}
