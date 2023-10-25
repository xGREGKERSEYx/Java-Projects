package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class QuickSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int [] arr;
    private Stack<Integer> stack;
    private int low, high;
    private final Timer timer;

    public QuickSort(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.stack = new Stack<>();
        this.stack.push(0);
        this.stack.push(arr.length - 1);
        this.low = 0;
        this.high = arr.length - 1;
        this.timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stack.empty()){
                    high = stack.pop();
                    low = stack.pop();
                    int pivot = partition(low, high);
                    if (pivot - 1 > low){
                        stack.push(low);
                        stack.push(pivot - 1);
                    }
                    if (pivot + 1 < high){
                        stack.push(pivot + 1);
                        stack.push(high);
                    }
                    visualizer.updateVisualizationPanel();
                }else {
                    timer.stop();
                }
                /*if (low < high){
                    int partitionIndex = partition(low, high);
                    if (low < partitionIndex - 1){
                        quickSort(low, partitionIndex - 1);
                    }
                    if (partitionIndex < high){
                        quickSort(partitionIndex, high);
                    }
                    visualizer.updateVisualizationPanel();
                }else{
                    timer.stop();
                }*/
            }
        });
    }
    int partition(int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(i,j);
            }
        }
        swap(i + 1, high);
        return  i + 1;

        /*
        while (low <= high){
            while (arr[low] < pivot){
                low++;
            }
            while (arr[high] > pivot){
                high--;
            }
            if (low <= high){
                swap(low, high);
                low++;
                high--;
            }
        }
        return  low;*/
    }
    private void quickSort(int low, int high){
        int partitionIndex = partition(low, high);
        if (low < partitionIndex - 1) {
            quickSort(low, partitionIndex - 1);
        }
        if (partitionIndex < high) {
            quickSort(partitionIndex, high);
        }
    }
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    @Override
    public void toSort(SortingVisualizer visualizer) {
        timer.start();
    }

    @Override
    public void stopSorting() {
        timer.stop();
    }
}//Worst case time complexity is O(N^2)
