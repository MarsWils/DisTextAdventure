package Controller;

import People.NPCs;
import Places.Places;
import Places.Directions;
import Places.ExplorationCommands;
import Player.Player;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

public class NavigationController implements ActionListener, SubController<Directions>{
    private SuperController listener;

    public NavigationController() {
        Player.setLocation(Places.MANOR_ENTRANCE_HALL);
    }

    public void actionPerformed(ActionEvent e) {
        Player.move(((CommandButton<Directions>)e.getSource()).getCommand());
        listener.modelUpdated();
    }

    @Override
    public String getTitle() {
        return "Exploring " + Player.getLocation().getName();
    }

    @Override
    public String getText() {
        String text = Player.getLocation().getDescription();
        for(NPCs npc : Player.getLocation().getNpcs()) {
            text = text +
                    "\n" +
                    "\n" +
                    npc.getBasicDescription();
        }
        return text;
    }

    @Override
    public Set<CommandButton> getButtons() {
        ButtonPanel<Directions> bp = new ButtonPanel<Directions>();
        bp.setController(this);
        bp.setButtons(Player.getLocation().getDirections());
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
    public String getButtonLabel(Directions direction) {
        return direction.toString();
    }
}

