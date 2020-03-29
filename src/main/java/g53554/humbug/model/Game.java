package g53554.humbug.model;

/**
 * Gme class that start the game and apply the moves and the changes
 *
 * @author jj
 */
public class Game implements Model {

    private Board board = Board.getInitBoard();
    private Animal[] animals = new Animal[]{
        new Snail(new Position(0, 0)),};

    /**
     * return the board of the game
     *
     * @return board
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * return the animals
     *
     * @return animals
     */
    @Override
    public Animal[] animals() {

        return this.animals;
    }

    /**
     * Start the game according to the level
     *
     * @param level
     */
    @Override
    public void startLevel(int level) {
        getBoard();
        animals();

    }

    /**
     * return a boolean if all the animal are on star the they win
     *
     * @return boolean
     */
    @Override
    public boolean levelIsOver() {
        int i = 0;
        while (i < animals().length && animals()[i].isOnStar()) {
            i++;
        }
        return animals().length == i;
    }

    /**
     * Move the animal from one position to another according to the direction
     *
     * @param position
     * @param direction
     */
    @Override
    public void move(Position position, Direction direction) {
        if (position == null || direction == null) {
            throw new IllegalArgumentException("Position ou direction null");
        }
        int i = 0;
        boolean move = false;
        while (i < animals().length && !move) {
            if (!animals()[i].getPositionOnBoard().equals(position)) {
                System.out.println("");
                System.out.println("Pas d'animal dans cette case ");
            } else {
                Position movePos = animals()[i].move(board, direction, animals());
                if (movePos == null) {
                    move = true;
                } else {
                    
                    move = true;
                }
            }

            i++;

        }

    }

}
