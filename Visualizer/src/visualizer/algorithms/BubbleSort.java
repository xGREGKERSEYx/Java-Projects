
package visualizer.algorithms;


import visualizer.ui.SortingVisualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

//https://www.geeksforgeeks.org/java-program-for-bubble-sort/#

public class BubbleSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int[] arr;
    private int i, j;
    private final Timer timer;

    public BubbleSort(SortingVisualizer visualizer) {
        if (visualizer == null) {
            throw new IllegalArgumentException("Visualizer cannot be null");
        }
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.i = 0;
        this.j = 0;
        this.timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i < arr.length - 1){
                    if(j < arr.length - i - 1){
                        if(arr[j] > arr[j + 1]){
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;

                            visualizer.updateVisualizationPanel();
                        }
                        j++;
                    }else{
                        j = 0;
                        i++;
                    }
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

