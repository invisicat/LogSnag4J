package cc.ricecx.logsnag4j;

public class Emoji {

    private final String emoji;

    private Emoji(String emoji) {
        this.emoji = emoji;
    }

    public static Emoji of(String emoji) {
        return new Emoji(emoji);
    }

    public String getEmoji() {
        return emoji;
    }
}
