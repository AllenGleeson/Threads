public class Product {
    // Data members
    private int id;
    private String name;
    private String material;
    private String industry;
    private double price;

    // Constructor
    public Product(int id, String name, String material, String industry, double price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.industry = industry;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public String getIndustry() {
        return industry;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // ToString for printing
    @Override
    public String toString() {
        return "Product: - " +
                "ID: " + id +
                ", Name: " + name +
                ", Material: " + material +
                ", Industry: " + industry +
                ", Price: " + String.format("%.2f", price);
    }

    public static void main(String[] args) {
        // Testing Product Class
        System.out.println();
        System.out.println("------------------------------");
        Product product = new Product(1, "Test Name", "Test Material", "Test Industry", 30.50);
        System.out.println(product);
        System.out.println("------------------------------");
    }
}