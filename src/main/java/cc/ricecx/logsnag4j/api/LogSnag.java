package cc.ricecx.logsnag4j.api;

import cc.ricecx.logsnag4j.Emoji;
import cc.ricecx.logsnag4j.LogSnagRequest;
import cc.ricecx.logsnag4j.http.LogSnagHTTPClient;

/**
 * An interface representing a LogSnag client.
 * @author RiceCX
 * @since 1.0
 */
public interface LogSnag {

    /**
     * Send a log message to LogSnag
     *
     * @param request The {@link LogSnagRequest} to send to LogSnag
     */
    void log(LogSnagRequest request);

    /**
     * Logs a message to LogSnag
     * @param event The event name
     * @param channel The channel name
     * @param description The description of the event
     */
    default void log(String event, String channel, String description) {
        log(new LogSnagRequest(event, channel, description, getProject()));
    }

    /**
     * Logs a message to LogSnag
     * @param event The event name
     * @param channel The channel name
     * @param description The description of the event
     */
    default void log(String event, String channel, String description, Emoji icon) {
        log(new LogSnagRequest(event, channel, description, icon, getProject()));
    }

    /**
     * Logs a message to LogSnag
     * @param event The event name
     * @param channel The channel name
     * @param description The description of the event
     */
    default void log(String event, String channel, String description, boolean notify, Emoji icon) {
        log(new LogSnagRequest(event, channel, description, notify, icon, getProject()));
    }

    /**
     * Logs a message to LogSnag
     * @param event The event name
     * @param channel The channel name
     * @param description The description of the event
     */
    default void log(String event, String channel, String description, boolean notify) {
        log(new LogSnagRequest(event, channel, description, notify, getProject()));
    }

    /**
     * Sends a message to LogSnag and then calls the callback
     * if the message was successfully sent.
     * @param request The {@link LogSnagRequest} to send to LogSnag
     * @param consume The callback to call if the message was successfully sent
     */
    void logCallback(LogSnagRequest request, Runnable consume);

    /**
     * Gets the current project name
     * @return The current project name
     */
    String getProject();

    /**
     * Sets the project name
     * @param project The project name
     */
    void setProject(String project);

    /**
     * Gets the current HTTP client used to send messages to LogSnag.
     * By default, this is a {@link LogSnagHTTPClient} which is
     * asynchronous. Though, you can use {@link LogSnag#setHttpClient(LogSnagHTTPClient)}
     * to use your own.
     * @return The current HTTP client
     */
    LogSnagHTTPClient getHttpClient();

    /**
     * Sets the HTTP client used to send messages to LogSnag. This particularly
     * useful if you want to use your own HTTP client or want to set custom
     * headers and such.
     * @param httpClient The HTTP client to use
     */
    void setHttpClient(LogSnagHTTPClient httpClient);
}
