package Player;

import Places.Directions;
import Places.Places;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void moveChangesLocation() {
        Places origin = Places.MANOR_ENTRANCE_HALL;
        Places destination = Places.MANOR_PARLOR;
        Player.setLocation(origin);

        Player.move(Directions.NORTH);

        assertEquals(destination, Player.getLocation());
    }
}