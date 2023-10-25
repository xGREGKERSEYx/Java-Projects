package visualizer.algorithms;

import visualizer.ui.SortingVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MergeSort implements SortingInterface{
    private final SortingVisualizer visualizer;
    private final int[] arr, tempArr;
    private int left, mid, right;
    private final Timer timer;

    public MergeSort(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.arr = visualizer.getArrayToSort();
        this.tempArr = new int[arr.length];
        this.left = 0;
        this.right = arr.length - 1;
        this.timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (left < right){
                    mid = (left + right) / 2;
                    merge(left, mid, right);
                    visualizer.updateVisualizationPanel();
                }else {
                    timer.stop();
                }

            }
        });
    }
    private void merge(int left, int mid, int right) {
        int lengthOne = mid - left + 1;
        int lengthTwo = right - mid;

        int [] leftArray = new int[lengthOne];
        int [] rightArray = new int[lengthTwo];

        System.arraycopy(arr, left, leftArray, 0, lengthOne);
        System.arraycopy(arr, mid + 1, rightArray, 0, lengthTwo);

        int i = 0, j = 0, k = left;
        while(i < lengthOne && j < lengthTwo){
            if (leftArray[i] <= rightArray[j]){
                arr[k++] = leftArray[i++];
            }else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < lengthOne){
            arr[k++] = leftArray[i++];
        }
        while (j < lengthTwo){
            arr[k++] = rightArray[j++];
        }
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
