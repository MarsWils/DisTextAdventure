package View;

import Controller.SubController;
import Places.ExplorationCommands;

import java.util.Set;
import java.util.TreeSet;

public class SideButtonFactory {
    private SubController controller;
    private Set<CommandButton> buttons;

    public SideButtonFactory() {
        buttons = new TreeSet<>();
    }

    public void setButtons(Set<ExplorationCommands> commands) {
        for (ExplorationCommands command : commands) {
            CommandButton<ExplorationCommands> button = new CommandButton(command, command.toString());
            button.addActionListener(controller);
            buttons.add(button);
        }
    }

    public Set<CommandButton> getButtons() {
        return buttons;
    }

    public void setController(SubController controller) {
        this.controller = controller;
    }
}
