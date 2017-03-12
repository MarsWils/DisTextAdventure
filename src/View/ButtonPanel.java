package View;

import Controller.SubController;

import java.util.Set;
import java.util.TreeSet;

public class ButtonPanel<T> {
    private SubController controller;
    private Set<CommandButton> buttons;

    public ButtonPanel() {
        buttons = new TreeSet<>();
    }

    public <T> void setButtons(Set<T> commands) {
        for (T command : commands) {
            CommandButton<T> button = new CommandButton(command, controller.getButtonLabel(command));
            button.addActionListener(controller);
            buttons.add(button);
        }
    }

    public Set<CommandButton> getButtons() {
        return buttons;
    }

    public void setController(SubController<T> controller) {
        this.controller = controller;
    }
}
