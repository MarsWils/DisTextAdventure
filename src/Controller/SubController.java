package Controller;

import View.CommandButton;

import java.awt.event.ActionListener;
import java.util.Set;

public interface SubController <T> extends ActionListener {
    String getTitle();

    String getText();

    Set<CommandButton> getButtons();

    Set<CommandButton> getSideButtons();

    void setListener(SuperController superController);

    String getButtonLabel(T command);
}
