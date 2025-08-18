public class Product {
    private int id;
    private String name;
    private String type;      // e.g., "Steel", "Granite"
    private String industry;  // e.g., "Games", "Beauty"
    private int price;        // you could also use double for currency

    public Product(int id, String name, String type, String industry, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public String getIndustry() {
        return industry;
    }

    public int getPrice() {
        return price;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // ToString for printing
    @Override
    public String toString() {
        return "Product:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", industry='" + industry + '\'' +
                ", price=" + price;
    }
}