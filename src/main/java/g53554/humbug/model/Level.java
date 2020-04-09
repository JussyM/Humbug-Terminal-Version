package g53554.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Logger;

/**
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

    private Board board;
    private Animal[] animals;
    private int nMoves;

    /**
     *
     * @param board
     * @param animals
     * @param nMoves
     */
    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     *
     * @return
     */
    public Board getBoard() {
        return board;
    }

    /**
     *
     * @return
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     *
     * @return
     */
    public int getnMoves() {
        return nMoves;
    }

    /**
     *
     * @param i
     * @return
     * @throws IOException
     */
    private static Level readLevel(int i) throws IOException {
        var objectMapper = new ObjectMapper();
        var inputStream = Level.class.getResourceAsStream(
                "data/level-" + i + ".json");
        var level = objectMapper.readValue(inputStream, Level.class);
        return level;

    }

}
