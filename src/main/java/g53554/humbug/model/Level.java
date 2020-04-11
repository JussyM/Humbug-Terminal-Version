package g53554.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * Represent the level of the game level class
 *
 * @author jj
 */
public class Level {
    /**
     * Return the level of the game
     *
     * @param n the number of level
     * @return new level of the game
     */
    public static Level getLevel(int n) {
        try {
            return readLevel(n);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    /**
     * read the level from the json file given
     *
     * @param i reprensente the level of the game
     * @return Level
     * @throws IOException Exception throws if error occure
     */
    private static Level readLevel(int i) throws IOException {
        var objectMapper = new ObjectMapper();
        var inputStream = Level.class.getResourceAsStream(
                "/data/level-" + i + ".json");
        var level = objectMapper.readValue(inputStream, Level.class);
        return level;

    }

    private Board board;
    private Animal[] animals;
    private int nMoves;


    /**
     * Contructor of Level with all the tree attribut as argument
     *
     * @param board of the game
     * @param animals arrays that contain all the animals of the game
     * @param nMoves number of move autorized
     */
    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Default constructor to initiazed the level
     */
    public Level() {
    }

    /**
     * getter of board
     *
     * @return board of the game
     */
    public Board getBoard() {
        return board;
    }

    /**
     * getter of animals
     *
     * @return animals of the games
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * getter of nMoves
     *
     * @return number of movement allow
     */
    public int getnMoves() {
        return nMoves;
    }

}
