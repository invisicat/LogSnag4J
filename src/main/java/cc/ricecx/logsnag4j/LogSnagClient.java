package cc.ricecx.logsnag4j;

import cc.ricecx.logsnag4j.api.LogSnag;
import cc.ricecx.logsnag4j.exceptions.LogSnagException;
import cc.ricecx.logsnag4j.http.LogSnagHTTPClient;
import cc.ricecx.logsnag4j.http.DefaultLogSnagHttpClient;

/**
 * A class that represents the LogSnag API exposed
 * as a client.
 */
public class LogSnagClient implements LogSnag {

    /**
     * The LogSnag HTTP endpoint
     * @since 1.0
     */
    public static final String ENDPOINT =  "https://api.logsnag.com/v1/log";


    private LogSnagHTTPClient httpClient;
    private final String apiKey;

    private String project;

    /**
     * Creates a new LogSnagClient with the given apiKey
     * @param apiKey the apiKey to use. You can request for one <a href="https://app.logsnag.com/dashboard/profile/api">here</a>
     * @param project The project name
     */
    public LogSnagClient(String apiKey, String project) {
        this.apiKey = apiKey;
        this.project = project;
        this.httpClient = new DefaultLogSnagHttpClient();

        if(apiKey == null || apiKey.isEmpty()) throw new LogSnagException("apiKey cannot be null or empty");
    }

    @Override
    public void log(LogSnagRequest request) {
        httpClient.sendRequest(request.serialize(), apiKey);
    }

    @Override
    public void logCallback(LogSnagRequest request, Runnable consume) {
        httpClient.sendRequest(request.serialize(), apiKey, consume);
    }


    /**
     * Gets the current project name
     * @return the current project name
     */
    public String getProject() {
        return project;
    }

    /**
     * Sets the current project name
     * @param project The project name
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Gets the current LogSnag HTTP client
     * @return the current LogSnag HTTP client
     */
    public LogSnagHTTPClient getHttpClient() {
        return httpClient;
    }

    /**
     * Sets the current LogSnag HTTP client
     * @param httpClient The HTTP client to use
     */
    public void setHttpClient(LogSnagHTTPClient httpClient) {
        this.httpClient = httpClient;
    }
}
