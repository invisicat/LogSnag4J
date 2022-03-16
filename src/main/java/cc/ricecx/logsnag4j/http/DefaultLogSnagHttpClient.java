package cc.ricecx.logsnag4j.http;

import cc.ricecx.logsnag4j.LogSnagClient;
import cc.ricecx.logsnag4j.exceptions.LogSnagException;

import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * An implementation of {@link LogSnagClient} that uses the Java 11 HTTP client.
 * It is recommended to use this implementation as it is async.
 * @author RiceCX
 * @since 1.0
 */
public class DefaultLogSnagHttpClient implements LogSnagHTTPClient {

    private final HttpClient httpClient;

    public DefaultLogSnagHttpClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .version(HttpClient.Version.HTTP_2)
                .build();
    }


    @Override
    public void sendRequest(String data, String apiKey) {
        wrapRequest(createRequest(data, apiKey), () -> {});
    }

    @Override
    public void sendRequest(String data, String apiKey, Runnable onFinish) {
        wrapRequest(createRequest(data, apiKey), onFinish);
    }

    private HttpRequest createRequest(String data, String apiKey) {
        return HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .uri(URI.create(LogSnagClient.ENDPOINT))
                .setHeader("User-Agent", "LogSnag4J")
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    private void wrapRequest(HttpRequest req, @org.jetbrains.annotations.NotNull Runnable onFinish) {
        try {
            CompletableFuture<HttpResponse<String>> respFuture = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> resp = respFuture.join();

            onFinish.run();
            if (resp.statusCode() != 200) throw new LogSnagException("Error sending request to LogSnag: " + resp);
        } catch (LogSnagException e) {
            e.printStackTrace();
        }
    }
}
