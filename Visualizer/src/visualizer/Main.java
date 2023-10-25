package visualizer;

import visualizer.ui.SortingWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortingWindow::new);
    }
}