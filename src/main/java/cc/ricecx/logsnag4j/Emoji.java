package cc.ricecx.logsnag4j;

/**
 * A simple class to differentiate between an emoji and a normal string.
 * @author ricecx
 * @since 1.0
 */
public class Emoji {

    private final String emoji;

    /**
     * Converts a string into an emoji.
     * @param emoji The string to convert.
     */
    private Emoji(String emoji) {
        this.emoji = emoji;
    }

    /**
     * Converts a string into an emoji.
     * @param emoji The string to convert.
     * @return The emoji.
     */
    public static Emoji of(String emoji) {
        return new Emoji(emoji);
    }

    /**
     * Gets the emoji.
     * @return The emoji.
     */
    public String getEmoji() {
        return emoji;
    }
}
