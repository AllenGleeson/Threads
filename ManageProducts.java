import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProducts {
    private static List<Product> allProducts;

    public static void main(String[] args) {
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//companies.csv";
        allProducts = new ArrayList<>();

        readFile(name);
    }

    // Question 3 - A: read file
    // Reads a CSV file and populates the allProducts list to be used in other methods
    public static void readFile(String name) {
        try (Scanner scanner = new Scanner(new File(name))) {
            scanner.nextLine();
            System.out.println("Reading data: " + name);
            while (scanner.hasNextLine()) {
                String sGetData = scanner.nextLine();
                System.out.println(sGetData);
                String[] data = sGetData.split(";");

                Product product = new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]));
                allProducts.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Question 3 - B: write missing departments to new file
    public static void writeMissingDepartments() {
        // Create a new file to write products with missing departments
        File newFile = new File("MissingDepartment.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(newFile))) {
            // Loop through products and write products with missing departments
            for (Product product : allProducts) {
                if (product.getIndustry() == null || product.getIndustry().trim().isEmpty()) {
                    writer.println(
                        product.getId() + ";" +
                        product.getName() + ";" +
                        product.getType() + ";" +
                        product.getIndustry() + ";" +
                        product.getPrice()
                    );
                }
            }
            System.out.println("Missing departments written to " + newFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Question 3 - C: write granite products to new file
    public static void writeGraniteProducts() {
        File newFile = new File("granite_products.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(newFile))) {
            for (Product product : allProducts) {
                if ("Granite".equalsIgnoreCase(product.getType())) {
                    writer.println(
                        product.getId() + ";" +
                        product.getName() + ";" +
                        product.getType() + ";" +
                        product.getIndustry() + ";" +
                        product.getPrice()
                    );
                }
            }
            System.out.println("Products using granite written to " + newFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}