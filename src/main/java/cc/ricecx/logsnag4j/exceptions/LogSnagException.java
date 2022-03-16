package cc.ricecx.logsnag4j.exceptions;

import java.net.http.HttpRequest;

/**
 * This is thrown when an error occurs in the LogSnag4J library.
 * @author RiceCX
 * @since 1.0
 */
public class LogSnagException extends RuntimeException {

    public LogSnagException(String message) {
        super("LogSnag Exception - " + message);
    }
    public LogSnagException(String message, String data) {
        super("LogSnag Exception - " + message + "\n Data sent to LogSnag: " + (data == null ? "None" : data));
    }

    public LogSnagException(String message, HttpRequest data) {
        super("LogSnag Exception - " + message + "\n Data sent to LogSnag: " + (data == null ? "None" : data));
    }


}
