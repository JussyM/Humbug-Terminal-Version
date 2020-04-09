package g53554.humbug.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Gme class that start the game and apply the moves and the changes
 *
 * @author jj
 */
public class Game implements Model {

    private Board board;

    private Animal[] animals;
    private int remainingMove, currentLevel;

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
     * @return animals arrays of the animals
     */
    @Override
    public Animal[] animals() {
        Animal[] animalStillActive = animalStillOnBoard(List.of(animals));
        if (animalStillActive.length == 0) {
            return this.animals;
        } else {

            this.animals = animalStillOnBoard(List.of(animals));
        }

        return this.animals;
    }

    /**
     * Start the game according to the level
     *
     * @param nlevel
     */
    @Override
    public void startLevel(int nlevel) {
        Level level = Level.getLevel(nlevel);
        remainingMove = level.getnMoves();
        board = level.getBoard();
        animals = level.getAnimals();
        currentLevel = nlevel;
    }

    /**
     * Remove the animal of which the isOnStar field is true cause they ain't on
     * board anymore
     *
     * @param animals List of all the animals of the game
     * @return new Arrays of animals
     */
    private Animal[] animalStillOnBoard(List<Animal> animals) {
        List<Animal> listNoNull = animals.stream().filter(x -> {
            return !x.isOnStar();
        }).collect(Collectors.toList());
        Animal[] animalStillPresent
                = listNoNull.stream().toArray(x -> new Animal[x]);

        return animalStillPresent;
    }

    /**
     * Move the animal from one position to another according to the direction
     *
     * @param position of the animals
     * @param direction of where the animals is going
     */
    @Override
    public void move(Position position, Direction direction) {
        if (position == null || direction == null) {
            throw new IllegalArgumentException("Position ou direction null");
        }
        if (getLevelStatus() == LevelStatus.FAIL) {
            throw new IllegalStateException("Jeu pas en cours");

        }
        int i = 0;
        boolean move = false;
        while (i < animals().length && !move) {
            if (position.equals(animals()[i].getPositionOnBoard())) {

                Position movePos = animals()[i].move(board,
                        direction, animals());
                remainingMove--;
                if (getLevelStatus() == LevelStatus.FAIL) {
                    throw new IllegalStateException("Déplacement épuisé");
                }

                if (movePos == null) {
                    throw new NullPointerException("L'animal est sortie du jeu");
                } else {

                    move = true;
                }

            }
            i++;
        }

    }

    /**
     * return true or false if all the animal boolean turn to true
     *
     * @return true/false
     */
    private boolean levelIsOver() {
        int i = 0;
        while (i < animals().length && animals()[i].isOnStar()) {
            i++;
        }
        return animals().length == i;
    }

    /**
     * return the level status of the game according to it state
     *
     * @return levelStatus(enum)
     */
    @Override
    public LevelStatus getLevelStatus() {
        if (!levelIsOver() && getRemainingMoves() == 0) {
            return LevelStatus.FAIL;
        }
        if (!levelIsOver()) {
            return LevelStatus.IN_PROGRESS;
        }
        if (getRemainingMoves() == 0 && levelIsOver()) {
            return LevelStatus.WIN;
        }

        return null;
    }

    /**
     * return the remaining move of the game getter for remainingMove
     *
     * @return int remainingMove
     */
    @Override
    public int getRemainingMoves() {

        return remainingMove;
    }

    /**
     * getter for currentLevel of the game
     *
     * @return currentLevel
     */
    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

}
