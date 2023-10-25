package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadixSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int[] arr;
    private int left, mid, right;
    private final Timer timer;

    public RadixSort(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public void toSort(SortingVisualizer visualizer) {
        timer.start();
    }

    @Override
    public void stopSorting() {
        timer.stop();
    }
}
