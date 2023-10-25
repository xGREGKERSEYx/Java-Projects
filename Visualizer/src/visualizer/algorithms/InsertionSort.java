package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertionSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int[] arr;
    private int i, j, key;
    private final Timer timer;

    public InsertionSort(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.i = 1;
        this.j = 0;
        this.key = 0;
        this.timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (visualizer == null) {
                    throw new IllegalArgumentException("Visualizer cannot be null");
                }
                if (i < arr.length){
                    key = arr[i];
                    j = i - 1;

                    while(j >= 0 && arr[j] > key){
                        arr[j + 1] = arr[j];
                        j = j - 1;
                    }
                    arr[j + 1] = key;
                    visualizer.updateVisualizationPanel();
                    i++;
                }else{
                    timer.stop();
                }

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
}//Time Complexity: O(N^2)
