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
     *
     * @param positionOnBoard
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     *
     * @param board
     * @param direction
     * @param animal
     * @return
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        for (Animal animal1 : animal) {
            Position snailPos = animal1.getPositionOnBoard();
            if (board.isInside(snailPos.next(direction))
                    && board.getSquareType(snailPos.next(direction))
                    == SquareType.GRASS) {
                snailPos = snailPos.next(direction);
                return snailPos;
            } else if (board.isInside(snailPos.next(direction))
                    && board.getSquareType(snailPos.next(direction))
                    == SquareType.STAR) {
                animal1.setOnStar(true);
                animal1.setPositionOnBoard(null);
            } else if (snailPos.next(direction) == animal1.getPositionOnBoard()) {
                return snailPos;
            } else if (!board.isInside(snailPos.next(direction))) {
                return null;
            }

        }

        return null;
    }

}
