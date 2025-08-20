import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProducts {
    // Data members
    private static List<Product> allProducts;

    public static void main(String[] args) {
        allProducts = new ArrayList<>();
        readFile();
        writeMissingDepartments("MissingDepartment.txt");
        writeGraniteProducts("granite_products.txt");
    }

    // Question 3 - A: read file
    // Reads products.txt and prints to system output
    // Also populates the allProducts list to be used in other methods
    public static void readFile() {
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//products.txt";
        try (Scanner scanner = new Scanner(new File(name))) {
            System.out.println("------------------------------");
            System.out.println("Reading data: " + name);
            while (scanner.hasNextLine()) {
                // Scan each line and print to system output
                String sGetData = scanner.nextLine();
                System.out.println(sGetData);

                // Split by comma and create new Product with data
                String[] data = sGetData.split(",");
                Product product = new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Double.parseDouble(data[4]));
                // Adds product to allProducts to be used for Question 3 - B and D
                allProducts.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file: " + e.getMessage());
        }
    }

    // Question 3 - B: write missing departments to new file
    public static void writeMissingDepartments(String missingDepPath) {
        // Create a new file to write products with missing departments
        try {
            FileWriter fw = new FileWriter(missingDepPath);
            PrintWriter pw = new PrintWriter(fw);
            // Loop through products and write products with missing departments
            for (Product product : allProducts) {
                if (product.getIndustry() == null || product.getIndustry().trim().isEmpty()) {
                    pw.println(
                        product.getId() + "," +
                        product.getName() + "," +
                        product.getMaterial() + "," +
                        product.getIndustry() + "," +
                        String.format("%.2f", product.getPrice())
                    );
                }
            }
            pw.close();
            fw.close();
            System.out.println("Missing departments written to " + missingDepPath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Question 3 - D: write granite products to new file
    public static void writeGraniteProducts(String graniteFilePath) {
        try {
            FileWriter newFile = new FileWriter(graniteFilePath);
            PrintWriter writer = new PrintWriter(newFile);
            for (Product product : allProducts) {
                if ("Granite".equalsIgnoreCase(product.getMaterial())) {
                    writer.println(
                        product.getId() + "," +
                        product.getName() + "," +
                        product.getMaterial() + "," +
                        product.getIndustry() + "," +
                        String.format("%.2f", product.getPrice())
                    );
                }
            }
            writer.close();
            newFile.close();
            System.out.println("Products using granite written to " + graniteFilePath);
        }
        catch (IOException e) {
            System.out.println("Error writing granite products file: " + e.getMessage());
        }
    }
}