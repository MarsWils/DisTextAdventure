package People;

import Player.Player;

public class KeywordReplacer {

    public static String replace(String s) {
        s = s.replaceAll("%PLAYERNAME%", Player.getName());
        return s;
    }
}
