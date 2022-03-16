package cc.ricecx.logsnag4j.http;

import java.util.function.Consumer;

/**
 * An interface for a LogSnagHTTP Client.
 * @author RiceCX
 * @since 1.0
 */
public interface LogSnagHTTPClient {

    void sendRequest(String data, String apiKey);


    void sendRequest(String data, String apiKey, Runnable onFinish);
}
