import java.util.ArrayList;

public class DrawerThreadsApp {
  private static int sum;
  private static int max;
  private static int min;
  private static int avg;

  public static void main(String[] args) {
    // Generate data for drawers
    ArrayList[] drawersData = Taba.generateData();
    int dataLength = drawersData.length;
    DrawerThread[] drawerThreads = new DrawerThread[dataLength];
    Thread[] threads = new Thread[dataLength];
    // Fill DrawerThread array with new DrawerThreads with each drawers data
    for (int i = 0; i < dataLength; i++) {
      drawerThreads[i] = new DrawerThread(drawersData[i]);
      threads[i] = new Thread(drawerThreads[i]);
    }

    // Question 2 - A: Start each DrawerThread and calculate sum, max, min, and
    // average
    // Starts each DrawerThread
    int i = 0;
    System.out.println("Starting DrawerThreads...");
    for (Thread thread : threads) {
      System.out.println("Starting DrawerThread " + (++i));
      thread.start();
    }

    // Uses .join() to wait for each thread to finish before getting the grand totals
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    i = 0;
    for (DrawerThread drawerThread : drawerThreads) {
      System.out.println("DrawerThread " + (++i) + " finished with results:");
      System.out.println("Sum: " + drawerThread.getSum());
      System.out.println("Max: " + drawerThread.getMax());
      System.out.println("Min: " + drawerThread.getMin());
      System.out.println("Average: " + drawerThread.getAvg());
      System.out.println("-----------------------------");
    }

    // Question 2 - B: Grand Total
    calc(drawerThreads);
    System.out.println("Final Results:");
    System.out.println("Grand Sum: " + sum);
    System.out.println("Grand Max: " + max);
    System.out.println("Grand Min: " + min);
    System.out.println("Grand Average: " + avg);
    System.out.println("DrawerThreads finished.");
    System.out.println("-----------------------------");
  }

  // Method to calculate grand total sum, max, min, and average
  private static void calc(DrawerThread[] drawers) {
    for (DrawerThread drawer : drawers) {
      sum += drawer.getSum();
      if (drawer.getMax() > max) {
        max = drawer.getMax();
      }
      if (drawer.getMin() < min) {
        min = drawer.getMin();
      }
    }
    avg = sum / drawers.length;
  }
}