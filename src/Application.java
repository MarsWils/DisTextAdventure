import Controller.SuperController;

import java.awt.*;

public class Application {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SuperController controller = new SuperController();
            controller.start();
        });
    }


}
