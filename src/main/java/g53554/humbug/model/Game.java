package g53554.humbug.model;

/**
 * This class
 *
 * @author jj
 */
public class Game implements Model {

    private Board board;
    private Animal[] animals;

    /**
     * return the board of the game
     *
     * @return board
     */
    @Override
    public Board getBoard() {
        return this.board = Board.getInitBoard();
    }

    /**
     * return the animals
     *
     * @return animals
     */
    @Override
    public Animal[] animals() {
        Animal[] animals = new Animal[]{
            new Snail(new Position(0, 0)),};
        return this.animals = animals;
    }

    public Animal[] getAnimals() {
        return animals();
    }

    /**
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
            if (animals()[i].move(board, direction, animals) == null) {
                System.out.println("L'animal est sortie du jeu");
                move = true;
            } else {
                animals()[i].move(board, direction, animals);
                move = true;
            }
            i++;
        }

    }

}
