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
     * @param level of each games
     */
    @Override
    public void startLevel(int level) {
        board = Board.getInitBoard();
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new GrassHopper(new Position(0, 1))};

    }

    /**
     * Remove the animal of which the position is null cause thy ain't on board
     * anymore
     *
     * @param animals List of all the animals of the game
     * @return Arrays of animals whose position ain't null
     */
    private Animal[] animalStillOnBoard(List<Animal> animals) {
        List<Animal> listNoNull = animals.stream().filter(x -> {
            return x.getPositionOnBoard() != null;
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
        int i = 0;
        boolean move = false;
        while (i < animals().length && !move) {
            if (position.equals(animals()[i].getPositionOnBoard())) {
                Position movePos = animals()[i].move(board,
                        direction, animals());
                if (movePos == null) {
                    move = true;
                } else {

                    move = true;
                }

            }
            i++;
        }

    }

    @Override
    public LevelStatus getLevelStatus() {
        return null;
    }

    @Override
    public int getRemainingMoves() {
        return 0;
    }

}
