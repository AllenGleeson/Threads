public class DrawerThread implements Runnable {
    // Data members
    private int sum;
    private int max;
    private int min;
    private int avg;
    Product[] products;

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
    public DrawerThread(Product[] products) {
        this.products = products;
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
    
    // Method to calculate sum, max, min, and average
    private void calc() {
        if (products == null || products.length == 0) {
            System.out.println("No products available.");
            return;
        }
        for (Product product : products) {
            int price = product.getPrice();
            sum += price;
            if (price > max) {
                max = price;
            }
            if (price < min) {
                min = price;
            }
        }
        avg = sum / products.length;
    }
}