package Controller;

import View.View;
import View.DefaultView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperController implements ActionListener {
    private View view;
    private SubController subController;

    public SuperController() {
    }

    public void start() {
        subController = new NavigationController();
        subController.setListener(this);

        view = new DefaultView(this);
        view.initUI();
        populateView();
        view.setVisible(true);
    }

    private void populateView() {
        view.setTitle(subController.getTitle());
        view.setText(subController.getText());
        view.setButtons(subController.getButtons());
        view.setSideButtons(subController.getSideButtons());
    }

    public void actionPerformed(ActionEvent e) {
        populateView();
    }

    public void modelUpdated() {
        populateView();
        view.Refresh();
    }
}