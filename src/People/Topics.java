package People;

import java.util.Optional;

public enum Topics {

    //region Jade Topics
    JADE_GREETING("GREETING","Hello!"),
    JADE_SELF("JADE", "My name's Jade. I hunt dragons"),
    JADE_PLAYER("PLAYER", "Pleased to meet you."),
    JADE_DRAGON("DRAGON", "Dragons are dangerous."),
    //endregion

    //region Maid Topics
    MAID_GREETING("GREETING",
            "As %PLAYERNAME% approaches the maid she bows low." +
            "\n" +
            "\n" +
            "\"Welcome home.\" she says."),
    MAID_SELF("MAID",
            "Content for Maid"),
    MAID_AUNT("AUNT",
            "Content for Aunt"),
    MAID_MANOR("MANOR",
            "\"What is this place?\""),
    MAID_TWO_HUNDRED_YEARS("TWO HUNDRED YEARS",
            "Content for Two Hundred Years"),
    MAID_PART_HUMAN("PART HUMAN",
            "Content for Part Human"),
    MAID_DEMON("DEMON",
            "Content for Demons"),
    MAID_ELYSIUM("ELYSIUM",
            "Content for Elysium"),
    MAID_SERVANT("SERVANT",
            "I am your Servant")
    //endregion

    ;

    private String buttonLabel;
    private String message;
    private UpdateNPCAction action;

    Topics(String label, String text) {
        this.buttonLabel = label;
        this.message = text;
    }

    void setAction(UpdateNPCAction a) {
        this.action = a;
    }

    static {
        MAID_SELF.setAction((NPCs n) -> {
            n.unlockTopics(Topics.MAID_AUNT);
            n.setName("Hilde");
        });
        MAID_AUNT.setAction((NPCs n) -> n.unlockTopics(Topics.MAID_PART_HUMAN, Topics.MAID_TWO_HUNDRED_YEARS, Topics.MAID_ELYSIUM));
        MAID_TWO_HUNDRED_YEARS.setAction((NPCs n) -> n.unlockTopics(Topics.MAID_TWO_HUNDRED_YEARS, Topics.MAID_DEMON));
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public String getMessage() {
        return message;
    }

    public Optional<UpdateNPCAction> getAction() {
        return Optional.ofNullable(action);
    }
}