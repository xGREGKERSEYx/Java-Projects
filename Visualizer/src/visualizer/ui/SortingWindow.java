package visualizer.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingWindow {
    int [] arrayToSort;
    SortingVisualizer visualizer;
    SortingLogic sortingLogic;
    JButton startButton, stopButton, resetButton;

    ImageIcon img = new ImageIcon("src/resources/icon.png");

    public SortingWindow(){
        //System.out.println("SortingWindow is being called");
        initiliaze();
    }
    private void initiliaze() {
        JFrame frame = new JFrame();
        frame.setTitle("Sorting Visualizer");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        frame.add(panelBottom, BorderLayout.PAGE_END);
        panelBottom.setBackground(Color.ORANGE);
        //Creates Panel that holds Start and Reset Buttons

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        frame.add(panelTop, BorderLayout.PAGE_START);
        panelTop.setBackground(Color.blue);
        //Creates top Panel that holds currently sorting

        String [] sortOptions = {"Bubble Sort", "Selection Sort", "Insertion Sort",
                "Merge Sort", "Quick Sort", "Heap Sort", "Counting Sort", "Radix Sort",
                "Bucket Sort", "Shell Sort"};
        JComboBox sortingOptionsDropdown = new JComboBox(sortOptions);
        panelBottom.add(sortingOptionsDropdown);
        //Adds the drop-down menu to the bottom panel
        /*https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html*/

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        panelBottom.add(startButton);
        panelBottom.add(stopButton);
        panelBottom.add(resetButton);
        //Adds buttons for starting and stopping to JPanel

        stopButton.setEnabled(false);
        resetButton.setEnabled(false);
        //disabled by default

        sortingLogic = new SortingLogic();
        arrayToSort = sortingLogic.generateRandomIntArray(10, 800, 30);
        visualizer = new SortingVisualizer(arrayToSort);
        sortingLogic.setArrayToSort(arrayToSort);
        sortingLogic.setVisualizer(visualizer);

        frame.getContentPane().add(visualizer);
        visualizer.setLayout(new FlowLayout(FlowLayout.CENTER));
        startButton.addActionListener(e -> {
            String selectedAlgorithm = (String) sortingOptionsDropdown.getSelectedItem();
            if (selectedAlgorithm != null){
                if (!sortingLogic.isSorted(arrayToSort)) {
                    sortingLogic.setSortingAlgorithm(selectedAlgorithm);
                    sortingLogic.startSorting();
                }else {
                    System.out.println("Array is sorted");
                }
            }
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            resetButton.setEnabled(true);
            //System.out.println("Start has been clicked");
        });//Performs sort that is selected under dropdownOptions and checks that it is not null or already sorted
        stopButton.addActionListener(e -> sortingLogic.stopSorting());
        resetButton.addActionListener(e -> {
            //System.out.println("Reset has been clicked");
            sortingLogic.stopSorting(); // Stop the sorting algorithm
            sortingLogic.resetArray();
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            resetButton.setEnabled(false);
        });
    }
}
