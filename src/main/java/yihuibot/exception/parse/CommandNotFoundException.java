package yihuibot.exception.parse;

/**
 * An exception for when no appropriate Executable can be found
 * with user's input.
 *
 * @author Toh Yi Hui A0259080A
 */
public class CommandNotFoundException extends ParseException {
    /**
     * Constructor for a new CommandNotFoundException.
     *
     * @param input the user's input.
     */
    public CommandNotFoundException(String input) {
        super("Sorry, I don't understand the command '" + input + "'.");
    }
}
