package cc.ricecx.logsnag4j;

import cc.ricecx.logsnag4j.api.JSONRequest;
import cc.ricecx.logsnag4j.api.LogSnag;
import cc.ricecx.logsnag4j.utils.Conditions;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

/**
 * A object that represents a standard LogSnag request
 *
 * @author ricecx
 * @since 1.0
 */
public class LogSnagRequest implements JSONRequest {

    private String event;

    private String channel;

    private String description;

    private boolean notify;

    private String icon;

    private String project;

    /**
     * Creates a new LogSnag request
     * @param event The event name that appears in LogSnag
     * @param channel The channel to send the log to
     * @param description A description of the log
     * @param notify Whether this log should push notifications
     * @param icon The icon to use for the log
     * @param project The project to send the log to
     */
    public LogSnagRequest(@NotNull String event, @NotNull String channel, String description, boolean notify, String icon, String project) {
        Conditions.checkNotNullOrEmpty(event, "Event name cannot be null!");
        Conditions.checkNotNullOrEmpty(channel, "Channel name cannot be null!");
        this.event = convertToSafe(event);
        this.channel = convertToSafe(channel);
        this.description = description;
        this.notify = notify;
        this.icon = icon;
        this.project = project;
    }

    /**
     * Creates a new LogSnag request
     * @param event The event name that appears in LogSnag
     * @param channel The channel to send the log to
     * @param description A description of the log
     * @param project The project to send the log to
     */
    public LogSnagRequest(String event, String channel, String description, String project) {
        this(event, channel, description, false, "🌐", project);
    }

    /**
     * Whether this log should push notifications
     * @param event The event name that appears in LogSnag
     * @param channel The channel to send the log to
     * @param description A description of the log
     * @param icon The icon to use for the log
     * @param project The project to send the log to
     */
    public LogSnagRequest(String event, String channel, String description, String icon, String project) {
        this(event, channel, description, false, icon, project);
    }

    /**
     * Creates a new LogSnag request
     * @param event The event name that appears in LogSnag
     * @param channel The channel to send the log to
     * @param description A description of the log
     * @param notify Whether this log should push notifications
     * @param project The project to send the log to
     */
    public LogSnagRequest(String event, String channel, String description, boolean notify, String project) {
        this(event, channel, description, true, "🌐", project);
    }

    /**
     * Uses a LogSnag request to send a log to LogSnag. This is shorthand for
     * {@link LogSnag#log(cc.ricecx.logsnag4j.LogSnagRequest)}
     * @param client The LogSnag client to use
     */
    public void sendRequest(LogSnagClient client) {
        client.log(this);
    }

    /**
     * This converts LogSnag strings into
     * their corresponding variant. This is following
     * the Logsnag API standards as:
     * <pre>
     *     The project and channel values should be lowercased! Alphabet characters, digits, and dashes "-" are accepted.
     * </pre>
     * The API can be found <a href="https://docs.logsnag.com/">here</a>
     *
     * @param string The string to convert
     * @return The converted String
     */
    public String convertToSafe(String string) {
        Conditions.checkNotNullOrEmpty(string, "String cannot be null!");

        return string.toLowerCase().replaceAll("\\s+", "-");
    }

    public String serialize() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("event", event);
        jsonObject.addProperty("channel", channel);
        jsonObject.addProperty("description", description);
        jsonObject.addProperty("notify", notify);
        jsonObject.addProperty("icon", icon);
        jsonObject.addProperty("project", project);

        return jsonObject.toString();
    }

    /**
     * Gets the event name that appears in LogSnag
     * @return The event name
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the event name that appears in LogSnag
     * @param event The event name that appears in LogSnag
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Gets the channel to send the log to
     * @return The channel name
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the channel to send the log to
     * @param channel The channel to send the log to
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets the description of the log
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the log
     * @param description The description of the log
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * If the log should push notifications
     * @return If the log should push notifications
     */
    public boolean isNotify() {
        return notify;
    }

    /**
     * Sets if the log should push notifications
     * @param notify If the log should push notifications
     */
    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    /**
     * Gets the icon to use for the log
     * @return The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the icon to use for the log
     * @param icon The icon to use for the log
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Gets the project to send the log to
     * @return The project name
     */
    public String getProject() {
        return project;
    }

    /**
     * Sets the project to send the log to
     * @param project The project to send the log to
     */
    public void setProject(String project) {
        this.project = project;
    }
}