package View;

import javax.swing.*;

public class CommandButton<T> extends JButton implements Comparable<CommandButton> {
    private T command;

    public CommandButton(T c, String s) {
        super(s);
        command = c;
    }

    public void setCommand(T t) {
        command = t;
    }

    public T getCommand() {
        return command;
    }

    @Override
    public int compareTo(CommandButton o) {
        return command.equals(o.getCommand()) ? 0 : 1; // Not happy with this
    }
}
