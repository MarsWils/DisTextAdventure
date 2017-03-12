package Controller;

import People.KeywordReplacer;
import People.NPCs;
import People.Topics;
import Places.ExplorationCommands;
import View.ButtonPanel;
import View.CommandButton;
import View.SideButtonFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

public class DialogueController implements ActionListener, SubController<Topics> {
    private NPCs npc;

    private String text;

    private SuperController listener;

    public DialogueController() {
        npc = NPCs.MAID;
        text = "";
        discussTopic(Topics.MAID_GREETING);
    }

    public void setNpc(NPCs npc) {
        this.npc = npc;
    }

    public void discussTopic(Topics topic) {
        if (topic != Topics.MAID_GREETING) {
            text = ">" + topic.getButtonLabel() +
                    "\n" +
                    "\n";
        }

        text = text +
                KeywordReplacer.replace(topic.getMessage()) +
                "\n" +
                "\n";

        topic.getAction().ifPresent(t -> {
            t.updateNPC(npc);
        });
    }

    public void actionPerformed(ActionEvent e) {
        discussTopic(((CommandButton<Topics>) e.getSource()).getCommand());
        listener.modelUpdated();
    }

    public String getTitle() {
        return "Talking to " + npc.getName();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Set<CommandButton> getButtons() {
        ButtonPanel<Topics> bp = new ButtonPanel<Topics>();
        bp.setController(this);
        bp.setButtons(npc.getTopics());
        return bp.getButtons();
    }

    @Override
    public Set<CommandButton> getSideButtons() {
        SideButtonFactory bp = new SideButtonFactory();
        bp.setController(this);
        bp.setButtons(new TreeSet<ExplorationCommands>() {{
            add(ExplorationCommands.MOVE);
            add(ExplorationCommands.EXAMINE);
            add(ExplorationCommands.TALK);
        }});
        return bp.getButtons();
    }

    @Override
    public void setListener(SuperController superController) {
        listener = superController;
    }

    @Override
    public String getButtonLabel(Topics topic) {
        return topic.getButtonLabel();
    }
}
