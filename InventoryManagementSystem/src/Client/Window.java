package Client;

import javax.swing.*;

public class Window {

    public Window() {
        initialize();
    }
    private void initialize() {
        JFrame frame = new JFrame();
        frame.setTitle("Blood Management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
    }
}
