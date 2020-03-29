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
     * @param board
     * @param direction
     * @param animal
     * @return new position
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        Position snailPos = super.getPositionOnBoard();
      

        if (!board.isInside(snailPos.next(direction))) {
          
            super.setPositionOnBoard(null);
            return null;

        } else if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.GRASS && isFree(snailPos.next(direction), 
                        animal)) {
            super.setPositionOnBoard(snailPos.next(direction));
            return super.getPositionOnBoard();

        } else if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.STAR) {
            super.setOnStar(true);
            super.setPositionOnBoard(snailPos.next(direction));
            board.setOnGrass(snailPos.next(direction));
            return super.getPositionOnBoard();

        } else if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.GRASS && !isFree(snailPos.next(direction),
                        animal)) {
            return snailPos;
        }
        return null;

    }

    /**
     * return a boolean true if the animal is on the board and false if not
     *
     * @param position
     * @param animal
     * @return found
     */
    private boolean isFree(Position position, Animal... animal) {
        int i = 0;
        boolean found = true;
        while (i < animal.length && found) {
            if (animal[i].getPositionOnBoard().equals(position)) {
                found = false;
            }
            i++;

        }
        return found;
    }

}
