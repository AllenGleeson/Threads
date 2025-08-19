import java.util.ArrayList;

public class DrawerThread implements Runnable {
    // Data members
    private int sum;
    private int max;
    private int min;
    private int avg;
    ArrayList drawer;

    // Getters
    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }

    // Constructor
    public DrawerThread(ArrayList drawer) {
        this.drawer = drawer;
        this.sum = 0;
        this.max = 0;
        this.min = 0;
        this.avg = 0;
    }

    @Override
    public void run() {
        System.out.println("New DrawerThread started.");
        calc();
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + avg);
        System.out.println("DrawerThread finished.");
    }

    // Question 2 - A: Calculate sum, max, min, and average
    // Method to calculate sum, max, min, and average
    private void calc() {
        if (drawer == null || drawer.size() == 0) {
            System.out.println("No drawer records.");
            return;
        }
        for (int iCount = 0; iCount < drawer.size(); iCount++) {
            int record = (int)drawer.get(iCount);
            sum += record;
            if (record > max) {
                max = record;
            }
            if (record < min) {
                min = record;
            }
        }
        avg = sum / drawer.size();
    }
}