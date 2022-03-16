package cc.ricecx.logsnag4j.http;


/**
 * An interface for a LogSnagHTTP Client.
 * @author RiceCX
 * @since 1.0
 */
public interface LogSnagHTTPClient {

    /**
     * Sends a request to the LogSnag HTTP API with the given data and the given API key.
     * @param data The data to send. Preferrably as a JSON string.
     * @param apiKey The API key to use.
     */
    void sendRequest(String data, String apiKey);


    /**
     * Sends a request to the LogSnag HTTP API with the given data, the given API key, and an optional callback.
     * @param data The data to send.
     * @param apiKey The API key to use.
     * @param onFinish The callback to call when the request is finished.
     */
    void sendRequest(String data, String apiKey, Runnable onFinish);
}
