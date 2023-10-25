package visualizer.ui;


import visualizer.algorithms.*;

import java.util.Random;

public class SortingLogic {
    private SortingVisualizer visualizer;
    private SortingInterface currentAlgorithm;
    private int[] arrayToSort;
    public SortingLogic() {
        //System.out.println("SortingLogic is being called");
    }
    public void setVisualizer(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
    }
    public int [] generateRandomIntArray(int min, int max, int length) {
        arrayToSort = new int[length];
        Random randNumGenerator = new Random();
        for (int i = 0; i < length; i++) {
            arrayToSort[i] = randNumGenerator.nextInt(max - min + 1) + min;
        }
        return arrayToSort;
    }
    public void setSortingAlgorithm(String algorithm) {
        switch (algorithm) {
            case "Bubble Sort":
                currentAlgorithm = new BubbleSort(visualizer);
                break;
            case "Selection Sort":
                currentAlgorithm = new SelectionSort(visualizer);
                break;
            case "Insertion Sort":
                currentAlgorithm = new InsertionSort(visualizer);
                break;
            case "Merge Sort":
                currentAlgorithm = new MergeSort(visualizer);
                break;
            case "Quick Sort":
                currentAlgorithm = new QuickSort(visualizer);
                break;
            case "Heap Sort":
                currentAlgorithm = new HeapSort(visualizer);
                break;
            case "Counting Sort":
                currentAlgorithm = new CountingSort(visualizer);
                break;
            /*case "Radix Sort":
                currentAlgorithm = new RadixSort(visualizer);
                break;
            case "Bucket Sort":
                currentAlgorithm = new BucketSort(visualizer);
                break;
            case "Shell Sort":
                currentAlgorithm = new ShellSort(visualizer);
                break;*/
            default:
                break;
        }
    }
    public void startSorting() {
        if (currentAlgorithm != null)
            currentAlgorithm.toSort(visualizer);
    }
    public void stopSorting() {
        if (currentAlgorithm != null) {
            currentAlgorithm.stopSorting();
        }
    }
    public int[] getArrayToSort() {
        return arrayToSort;
    }
    public void setArrayToSort(int[] newArray) {
        this.arrayToSort = newArray;
    }
    public void resetArray() {
        // Generate a new random array and update the visualizer
        arrayToSort = generateRandomIntArray(10, 800, 30);
        visualizer.setArrayToSort(arrayToSort);
        visualizer.updateVisualizationPanel();
    }
    public boolean isSorted(int [] arrayToSort){
        for (int i = 0; i < arrayToSort.length; i++){
            if (arrayToSort[i] > arrayToSort[i + 1]){
                return false;
            }
        }
        return true;
    }

}





