package People;

import Item.Items;

import java.util.Set;
import java.util.TreeSet;

public enum NPCs {
    JADE("Jade", "A young woman stands here.", new TreeSet<Topics>() {{
        add(Topics.JADE_SELF);
        add(Topics.JADE_PLAYER);
    }}, null),
    MAID("Maid", "A maid stands here.", new TreeSet<Topics>() {{
        add(Topics.MAID_SELF);
        add(Topics.MAID_MANOR);
    }}, null)
    ;

    private Set<Topics> topics;
    private Set<Items> items;
    private String name;
    private String basicDescription;

    NPCs(String n, String d, Set<Topics> t, Set<Items> i) {
        name = n;
        basicDescription = d;
        topics = t;
        items = i;
    }

    public Set<Topics> getTopics() {
        return topics;
    }

    public Set<Items> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void unlockTopics(Topics ...newTopics) {
        for(Topics newTopic : newTopics) {
            topics.add(newTopic);
        }
    }

    public void setName(String s) {
        name = s;
    }

    public String getBasicDescription() {
        return basicDescription;
    }
}
