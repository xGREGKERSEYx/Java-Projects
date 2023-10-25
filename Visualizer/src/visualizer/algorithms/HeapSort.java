package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeapSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int[] arr;
    private int N;
    private final Timer timer;

    public HeapSort(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.N = arr.length;
        this.timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (N > 1){
                   buildHeap();
                   swap(0, N - 1);
                   N--;
                   visualizer.updateVisualizationPanel();
               }else {
                   timer.stop();
               }
            }
        });
    }
    private void buildHeap(){
        for (int i = N / 2 - 1; i >= 0; i--){
            heapify(i);
        }
    }
    private void heapify(int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < N && arr[left] > arr[largest]){
            largest = left;
        }//if left child is larger than root

        if (right < N && arr[right] > arr[largest]){
            largest = right;
        }//if right child is larger than largest so far

        if (largest != i){
           swap(i, largest);
            heapify(largest);
        }

    }
    private void swap(int i, int j){
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
}//Time Complexity: O(N log N)
