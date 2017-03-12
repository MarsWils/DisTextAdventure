package People;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCsTest {
    @Test
    void unlockTopics() {

    }

}

//    private NPC npc;
//    private ArrayList<Topics> topicList;
//
//    @BeforeEach
//    void setUp() {
//        topicList = new ArrayList<>();
//        topicList.add(Topics.JADE_SELF);
//        topicList.add(Topics.MAID_AUNT);
//        topicList.add(Topics.MAID_TWO_HUNDRED_YEARS);
//
//        npc = new NPC();
//
//        npc.setTopics(new ArrayList<Topics>()
//        {{
//            add(Topics.JADE_SELF);
//            add(Topics.MAID_AUNT);
//            add(Topics.MAID_TWO_HUNDRED_YEARS);
//        }});
//
//        npc.setAllTopicContent(new HashMap<Topics, TopicContent>()
//        {{
//            put(Topics.JADE_SELF, new TopicContent("Jade!",(NPCs n) -> n.unlockTopics(Topics.MAID_SELF)));
//            put(Topics.MAID_AUNT, new TopicContent("Aunt!",null));
//            put(Topics.MAID_SELF, new TopicContent("Maid!", null));
//            put(Topics.MAID_SERVANT, new TopicContent("", null));
//            put(Topics.MAID_TWO_HUNDRED_YEARS, new TopicContent("", (NPCs n) -> n.unlockTopics(Topics.MAID_DEMON, Topics.JADE_BELLY)));
//            put(Topics.MAID_DEMON, new TopicContent("", null));
//            put(Topics.JADE_BELLY, new TopicContent("", null));
//        }});
//
//        npc.setAllItemContent(new HashMap<Items, TopicContent>()
//        {{
//            put(Items.TEST_ITEM, new TopicContent("Thanks for the item!", (NPCs n) -> n.unlockTopics(Topics.MAID_SERVANT)));
//        }});
//
//    }
//
//    @Test
//    void discussJade_returnsText() {
//        assertEquals("Jade!", npc.discussTopic(Topics.JADE_SELF));
//    }
//
//    @Test
//    void discussMaid_returnsText() {
//        npc.discussTopic(Topics.JADE_SELF);
//        assertEquals("Maid!", npc.discussTopic(Topics.MAID_SELF));
//    }
//
//    @Test
//    void keyDialogueUnlocksTopics() {
//        topicList.add(Topics.MAID_SELF);
//        npc.discussTopic(Topics.JADE_SELF);
//
//        assertEquals(topicList, npc.getTopics());
//    }
//
//    @Test
//    void keyDialogueUnlocksMultipleTopics() {
//        topicList.add(Topics.MAID_DEMON);
//        topicList.add(Topics.JADE_DRAGON);
//        npc.discussTopic(Topics.MAID_TWO_HUNDRED_YEARS);
//
//        assertEquals(topicList, npc.getTopics());
//    }
//
//    @Test
//    void regularDialogueUnlocksNothing() {
//        npc.discussTopic(Topics.MAID_AUNT);
//
//        assertEquals(topicList, npc.getTopics());
//    }
//
//    // Unlock by Size
//
//    // Unlock by Affection
//
//    @Test
//    void giftUnlocksDialogue() {
//        topicList.add(Topics.MAID_SERVANT);
//        npc.give(Items.TEST_ITEM);
//        assertEquals(topicList, npc.getTopics());
//    }
//
//    @Test
//    void unwantedGiftUnlocksNothing() {
//        npc.give(Items.TEST_DUD_ITEM);
//        assertEquals(topicList, npc.getTopics());
//    }