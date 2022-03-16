package cc.ricecx.logsnag4j.api;

/**
 * Simple interface to allow for easy
 * serializing.
 */
public interface JSONRequest {

    /**
     * A method to get the JSON payload of the request.
     * @return The JSON payload of the request as a string.
     */
    String serialize();
}
