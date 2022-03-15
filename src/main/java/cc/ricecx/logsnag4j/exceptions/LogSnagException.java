package cc.ricecx.logsnag4j.exceptions;

/**
 * This is thrown when an error occurs in the LogSnag4J library.
 * @author RiceCX
 * @since 1.0
 */
public class LogSnagException extends RuntimeException {

    public LogSnagException(String message) {
        super("LogSnag Exception - " + message);
    }
}
