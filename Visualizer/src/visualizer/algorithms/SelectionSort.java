package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSort implements SortingInterface {
    private final SortingVisualizer visualizer;
    private final int[] arr;
    private int i, j, min;
    private final Timer timer;

    public SelectionSort(SortingVisualizer visualizer) {
        if (visualizer == null) {
            throw new IllegalArgumentException("Visualizer cannot be null");
        }
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.i = 0;
        this.j = 0;
        this.min = 0;
        this.timer = new Timer(700, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i < arr.length - 1){
                    min = i;
                    for (j = i + 1; j < arr.length; j++){
                        if (arr[j] < arr[min]){
                            min = j;
                        }
                    }
                    if(min != i) {
                        int temp = arr[i];
                        arr[i] = arr[min];
                        arr[min] = temp;
                        //Swamp elements of the array

                        visualizer.updateVisualizationPanel();
                        //update array
                    }
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
}
