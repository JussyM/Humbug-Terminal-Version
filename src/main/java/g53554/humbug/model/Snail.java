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
        Position snailPos = super.getPositionOnBoard();

        if (!board.isInside(snailPos.next(direction))) {

            super.setPositionOnBoard(null);
            return null;
        }
        if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.GRASS && isFree(snailPos.next(direction),
                        animals)) {
            super.setPositionOnBoard(snailPos.next(direction));
            return super.getPositionOnBoard();
        }
        if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.STAR) {
            super.setOnStar(true);
            super.setPositionOnBoard(snailPos.next(direction));
            board.setOnGrass(snailPos.next(direction));
            return super.getPositionOnBoard();
        }
        if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.GRASS && !isFree(snailPos.next(direction),
                        animals) && !animalsIsOnStar(snailPos.next(direction),
                        animals)) {
            return snailPos;
        }
        if (board.isInside(snailPos.next(direction))
                && board.getSquareType(snailPos.next(direction))
                == SquareType.GRASS
                && !isFree(snailPos.next(direction), animals)
                && animalsIsOnStar(snailPos.next(direction), animals)) {
            super.setPositionOnBoard(snailPos.next(direction));
            Animal prens = animalOnNextSquare(snailPos.next(direction),
                    animals);
            prens.setPositionOnBoard(null);
            return super.getPositionOnBoard();
        }
        return null;
    }

}
