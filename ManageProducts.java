import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManageProducts {
    // Data members
    private static List<Product> allProducts;

    public static void main(String[] args) {
        allProducts = new ArrayList<>();
        // Question 3 - A: read file
        readFile("products.txt");
        // Question 3 - B: write missing departments to new file
        writeMissingDepartments("missing_departments_products.txt");
        // Question 3 - D: write granite products to new file
        writeGraniteProducts("granite_products.txt");
    }

    // Question 3 - A: read file
    // Reads products.txt and prints to system output
    // Also populates the allProducts list to be used in other methods
    public static void readFile(String sInputFileName) {
        // Checks for file called prodcuts.txt
        try (BufferedReader br = new BufferedReader(new FileReader(sInputFileName))) {
            String sOutputString;
            System.out.println("------------------------------");
            System.out.println("Reading data: " + sInputFileName);
            // Reads file line by line
            while ((sOutputString = br.readLine()) != null) {
                System.out.println(sOutputString);
                // Split data by comma and create new Product with data
                String[] data = sOutputString.split(",");
                Product product = new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Double.parseDouble(data[4]));
                // Adds product to allProducts to be used for Question 3 - B and D
                allProducts.add(product);
            }
        } catch (IOException e) {
            System.out.println("Cannot find file: " + e.getMessage());
        }
    }

    // Question 3 - B: write missing departments to new file
    public static void writeMissingDepartments(String missingDepPath) {
        // Create a new file to write products with missing departments
        try {
            // Creates a new FileWriter and PrintWriter using the missingDepPath
            FileWriter fw = new FileWriter(missingDepPath);
            PrintWriter pw = new PrintWriter(fw);
            // Loop through products and write products with missing departments information
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
            // Closes the PrintWriter and FileWriter
            pw.close();
            fw.close();
            System.out.println("Missing departments written to " + missingDepPath);
        } catch (IOException e) {
            // Catches IO exceptions and prints an error message
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Question 3 - D: write granite products to new file
    public static void writeGraniteProducts(String graniteFilePath) {
        try {
            // Creates a new FileWriter and PrintWriter using the graniteFilePath
            FileWriter fw = new FileWriter(graniteFilePath);
            PrintWriter pw = new PrintWriter(fw);
            for (Product product : allProducts) {
                // Loops though products and checks if the product's material is Granite then adds that product to the file
                if ("Granite".equalsIgnoreCase(product.getMaterial())) {
                    pw.println(
                        product.getId() + "," +
                        product.getName() + "," +
                        product.getMaterial() + "," +
                        product.getIndustry() + "," +
                        String.format("%.2f", product.getPrice())
                    );
                }
            }
            // Closes the PrintWriter and FileWriter
            pw.close();
            fw.close();
            System.out.println("Products using granite written to " + graniteFilePath);
        }
        catch (IOException e) {
            // Catches IO exceptions and prints an error message
            System.out.println("Error writing granite products file: " + e.getMessage());
        }
    }
}