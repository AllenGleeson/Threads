import java.util.ArrayList;

public class DrawerThreadsApp {
  private static int sum;
  private static int max;
  private static int min;
  private static int avg;

  public static void main(String[] args) {
    // Generate data for drawers
    ArrayList[] drawersData = Taba.generateData();

    // Initialize DrawerThread array
    DrawerThread[] drawerThreads = new DrawerThread[drawersData.length];

    // Fill DrawerThread array with new DrawerThreads with each drawers data
    for (int i = 0; i < drawersData.length; i++) {
      drawerThreads[i] = new DrawerThread(drawersData[i]);
    }

    // Question 2 - A: Start each DrawerThread and calculate sum, max, min, and average
    // Starts each DrawerThread
    int i = 0;
    System.out.println("Starting DrawerThreads...");
    for (DrawerThread drawerThread : drawerThreads) {
      System.out.println("Starting DrawerThread " + (++i));
      new Thread(drawerThread).start();
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