package visualizer.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortingVisualizer extends JPanel{
    private int[] arrayToSort;

    public int[] getArrayToSort() {
        return arrayToSort;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public SortingVisualizer(int[] arrayToSort) {
        this.arrayToSort = Arrays.copyOf(arrayToSort, arrayToSort.length);
        //System.out.println("SortingVisualizer is being called");
    }
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            int barWidth = getWidth() / arrayToSort.length;
            //System.out.println(Arrays.toString(arrayToSort) + "array within Visualizer's Paint Component");

            for (int j = 0; j < arrayToSort.length; j++) {//Enhanced for loops look at the values not the indices, so we do not use it
                int maxArrayValue = Arrays.stream(arrayToSort).max().getAsInt();
                int barHeight = (int) ((double) arrayToSort[j] / maxArrayValue * getHeight());                int x = j * barWidth;
                int y = getHeight() - barHeight;

                g.setColor(Color.red);
                g.fillRect(x, y, barWidth, barHeight);
                //Fills in a rectangular column
                g.setColor(Color.black);
                g.drawRect(x, y, barWidth, barHeight);
                //Creates a border for said columns

                //System.out.println("SortingVisualizer: /nBar Height " + barHeight +  "barWidth " + barWidth + "x " + x + "y" + y);
            }
        }
    public void updateVisualizationPanel() {
        //System.out.println("Repaint has been called");
        repaint(); // Trigger a repaint of the panel
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
