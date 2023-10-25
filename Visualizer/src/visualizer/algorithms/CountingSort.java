package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountingSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int[] arr;
    private int[] count;
    private int curr;
    private final Timer timer;

    public CountingSort(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.count = new int[getMaxValue(arr) + 1];
        this.curr = 0;

        this.timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(curr < arr.length){
                    count[arr[curr]]++;//store count for each character
                    visualizer.updateVisualizationPanel();
                    curr++;

                }else{
                    int index = 0;
                    for (int i = 0; i < count.length; i++){
                        while (count[i] > 0){
                            arr[index] = i;
                            index++;
                            count[i]--;
                            //visualizer.updateVisualizationPanel();
                        }
                    }
                    visualizer.updateVisualizationPanel();
                    if (index == arr.length){
                        timer.stop();
                    }

                }
            }
        });
    }

    private int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
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
