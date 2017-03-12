package Player;

import Places.Places;
import Places.Directions;

public class Player {
    private static int Size;
    private static Places location;
    private String name = "Player";

    public static int getSize() {
        return Size;
    }

    public static void setSize(int size) {
        Size = size;
    }

    public static Places getLocation() {
        return location;
    }

    public static void setLocation(Places location) {
        Player.location = location;
    }

    public static void move(Directions north) {
        location = location.getDestination(north);
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
