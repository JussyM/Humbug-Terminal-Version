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
        Position instance = super.getPositionOnBoard();

        if (!board.isInside(instance.next(direction))) {
            return null;
        } else if (board.isInside(instance.next(direction))
                && board.getSquareType(instance.next(direction))
                == SquareType.GRASS && isFree(instance.next(direction), animal)) {
            return instance.next(direction);

        } else if (board.isInside(instance.next(direction))
                && board.getSquareType(instance.next(direction))
                == SquareType.STAR) {
            super.setOnStar(true);
            super.setPositionOnBoard(instance.next(direction));
            SquareType type = board.getSquareType(instance);

            return super.getPositionOnBoard();

        }
        return null;
    }

    /**
     *
     * @param position
     * @param animal
     * @return
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

    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2))};
        Snail instance = (Snail) animals[1];
        //       Position expResult = new Position(2, 2);
        Position result = instance.move(Board.getInitBoard(),
                Direction.SOUTH, animals);
        System.out.println(result.getRow());
        System.out.println(result.getColumn());
    }

}
