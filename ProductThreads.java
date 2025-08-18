public class ProductThreads {
  private static int sum;
  private static int max;
  private static int min;
  private static int avg;

  public static void main(String[] args) {
    // Create an array of products
    Product[] products = {
        new Product(1, "Granite Slab", "Granite", "Construction", 500),
        new Product(2, "Lipstick", "Cosmetic", "Beauty", 20),
        new Product(3, "Game Console", "Electronics", "Games", 400),
        new Product(4, "Steel Beam", "Steel", "Construction", 300),
        new Product(5, "VR Headset", "Electronics", "Games", 250)
    };

    // Pass products into DrawerThread
    DrawerThread r1 = new DrawerThread(products);
    DrawerThread r2 = new DrawerThread(products);
    DrawerThread r3 = new DrawerThread(products);
    DrawerThread r4 = new DrawerThread(products);
    DrawerThread r5 = new DrawerThread(products);
    DrawerThread r6 = new DrawerThread(products);
    DrawerThread r7 = new DrawerThread(products);
    DrawerThread r8 = new DrawerThread(products);
    DrawerThread r9 = new DrawerThread(products);
    DrawerThread r10 = new DrawerThread(products);
    DrawerThread[] drawers = { r1, r2, r3, r4, r5, r6, r7, r8, r9, r10 };

    // Create threads for each drawer
    int i = 0;
    System.out.println("Starting DrawerThreads...");
    for (DrawerThread drawer : drawers) {
      System.out.println("Starting DrawerThread " + (++i));
      // Create a new thread for each DrawerThread
      new Thread(drawer).start();
    }

    calc(drawers);
    System.out.println("Final Results:");
    System.out.println("Sum: " + sum);
    System.out.println("Max: " + max);
    System.out.println("Min: " + min);
    System.out.println("Average: " + avg);
    System.out.println("DrawerThreads finished.");
  }

  // Method to calculate sum, max, min, and average
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