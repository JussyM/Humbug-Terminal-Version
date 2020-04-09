package g53554.humbug.view.text;

/**
 *
 * @author jj
 */
public class TerminalColor {

    /**
     * This method build the Bash default color
     *
     * @return La couleur default.
     */
    private static String toDefault() {
        return "\033[0m";
    }

    /**
     * This method color in black
     *
     * @param a The String that has to be color
     * @return The String already colored
     */
    public static String toBlack(String a) {
        return "\033[30m" + a + toDefault();
    }

    /**
     * This method color in red
     *
     * @param a The String that has to be color
     * @return The String already colored
     */
    public static String toRed(String a) {
        return "\033[31m" + a + toDefault();
    }

    /**
     * Colorie une chaine en vert.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toGreen(String a) {
        return "\033[32m" + a + toDefault();
    }

    /**
     * Colorie une chaine en jaune.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toYellow(String a) {
        return "\033[33m" + a + toDefault();
    }

    /**
     * Colorie une chaine en bleu.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toBlue(String a) {
        return "\033[34m" + a + toDefault();
    }

    /**
     * Colorie une chaine en mauve.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toPurple(String a) {
        return "\033[35m" + a + toDefault();
    }

    /**
     * Colorie une chaine en cyan.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public static String toCyan(String a) {
        return "\033[36m" + a + toDefault();
    }

    /**
     * Colorie une chaine en blanc.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toWhite(String a) {
        return "\033[37m" + a + toDefault();
    }

    /**
     * Affiche un message coloré pour montrer le but de la classe.
     */
    public String RESET = "\033[0m";  // Text Reset
    // Bold
    public String BLACK_BOLD = "\033[1;30m";  // BLACK
    public String RED_BOLD = "\033[1;31m";    // RED
    public String GREEN_BOLD = "\033[1;32m";  // GREEN
    public String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public String BLUE_BOLD = "\033[1;34m";   // BLUE
    public String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public String CYAN_BOLD = "\033[1;36m";   // CYAN
    public String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public String RED_UNDERLINED = "\033[4;31m";    // RED
    public String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static String RED_BACKGROUND = "\033[41m";    // RED
    public static String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public String RED_BRIGHT = "\033[0;91m";    // RED
    public String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    //Color Back_ground
    public String WhiteBackground = "\u001b[47m";
    public static String toDefault = "\u001b[0m";

}
