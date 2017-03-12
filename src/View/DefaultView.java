package View;

import Controller.SuperController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class DefaultView extends JFrame implements View {
    private JTextArea mainTextArea;
    private SuperController controller;
    private JPanel buttonPanel;
    private JPanel sidePanel;

    public DefaultView(SuperController superController) {
        controller = superController;
    }

    public void initUI() {
        initTextArea();
        createLayout();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void setText(String text) {
        mainTextArea.setText(text);
    }

    public void setButtons(Set<CommandButton> buttons) {
        buttonPanel.removeAll();
        for (CommandButton button : buttons) {
            buttonPanel.add(button, "grow");
        }
    }

    @Override
    public void setSideButtons(Set<CommandButton> buttons) {
        sidePanel.removeAll();
        for (CommandButton button : buttons) {
            sidePanel.add(button, "grow");
        }
    }

    private void initTextArea() {
        mainTextArea = new JTextArea();
        mainTextArea.setEditable(false);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setSize(750, 750);
    }

    private void createLayout() {
        Container contentPane = getContentPane();
        contentPane.removeAll();
        contentPane.setLayout(new MigLayout(
                "fill",
                "[]",
                "[grow][]"));

        sidePanel = new JPanel(new MigLayout("wrap 1"));

        contentPane.setPreferredSize(new Dimension(600, 400));

        contentPane.add(new JScrollPane(mainTextArea), "span, grow");

        contentPane.add(new JScrollPane(getBottomPanel()), "grow");

        contentPane.add(sidePanel, "west");
    }

    private JPanel getBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new MigLayout("",
                "[grow][][grow]",
                "[]"));

        bottomPanel.add(new JPanel(new MigLayout())); // Padding

        buttonPanel = new JPanel(new MigLayout("wrap 3"));

        bottomPanel.add(buttonPanel);

        bottomPanel.add(new JPanel(new MigLayout())); // Padding
        return bottomPanel;
    }

    public void Refresh() {
        revalidate();
        repaint();
    }
}