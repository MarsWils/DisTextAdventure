package Places;

import Item.Items;
import People.NPCs;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public enum Places {
    MANOR_ENTRANCE_HALL("A big hallway.", new TreeSet<NPCs>() {{
        add(NPCs.MAID);
    }}),
    MANOR_PARLOR("A fancy parlor.", new TreeSet<NPCs>() {{
        add(NPCs.JADE);
    }})
    ;

    private String name;
    private String description;
    private HashMap<Directions, Places> exits;
    private Set<Items> items;
    private Set<NPCs> npcs;

    Places(String s, Set<NPCs> n) {
        name = "a dump";
        description = s;
        exits = new HashMap<Directions, Places>();
        items = new TreeSet<>();
        npcs = n;
    }

    static {
        MANOR_ENTRANCE_HALL.exits = new HashMap<Directions, Places>() {{
            put(Directions.NORTH, MANOR_PARLOR);
        }};
        MANOR_PARLOR.exits = new HashMap<Directions, Places>() {{
            put(Directions.SOUTH, MANOR_ENTRANCE_HALL);
        }};


    }

    public String getDescription() {
        return description;
    }

    public HashMap<Directions, Places> getExits() {
        return exits;
    }

    public Places getDestination(Directions direction) {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public Set<Directions> getDirections() {
        return exits.keySet();
    }

    public Set<NPCs> getNpcs() {
        return npcs;
    }
}
