package View;

import java.util.Set;

public interface View {
    void Refresh();

    void setVisible(boolean b);

    void initUI();

    void setText(String text);

    void setButtons(Set<CommandButton> buttons);

    void setSideButtons(Set<CommandButton> buttons);

    void setTitle(String title);
}
