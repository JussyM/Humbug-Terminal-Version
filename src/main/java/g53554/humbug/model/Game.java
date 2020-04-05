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
        this.animals = animalStillOnBoard(List.of(animals));

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
            new Snail(new Position(0, 0)),};

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
     * return a boolean if all the animal are on star the they win
     *
     * @return boolean true of false if the game is over or not
     */
    @Override
    public boolean levelIsOver() {
        int i = 0;
        while (i <= animals().length && animals()[i].isOnStar()) {
            i++;
        }
        return animals().length == i;
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

}
