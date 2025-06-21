import java.util.*;

class Product {
    int id;
    String name;
    double price;
    String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name.toLowerCase(); // for easier search
        this.price = price;
        this.category = category.toLowerCase();
    }

    public boolean matches(String keyword, double minPrice, double maxPrice, String categoryFilter) {
        boolean keywordMatch = name.contains(keyword.toLowerCase());
        boolean priceMatch = price >= minPrice && price <= maxPrice;
        boolean categoryMatch = categoryFilter.isEmpty() || category.equalsIgnoreCase(categoryFilter);
        return keywordMatch && priceMatch && categoryMatch;
    }

    public String toString() {
        return "[ID: " + id + "] " + name + " - ₹" + price + " [" + category + "]";
    }
}

class ProductSearch {
    private List<Product> productList;

    public ProductSearch() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> search(String keyword, double minPrice, double maxPrice, String category) {
        List<Product> results = new ArrayList<>();
        for (Product p : productList) {
            if (p.matches(keyword, minPrice, maxPrice, category)) {
                results.add(p);
            }
        }
        return results;
    }
}

public class ECommerceSearch {
    public static void main(String[] args) {
        ProductSearch searchEngine = new ProductSearch();

        // Sample product list
        searchEngine.addProduct(new Product(101, "iPhone 13", 69999.0, "Electronics"));
        searchEngine.addProduct(new Product(102, "Nike T-Shirt", 1999.0, "Clothing"));
        searchEngine.addProduct(new Product(103, "Samsung TV", 39999.0, "Electronics"));
        searchEngine.addProduct(new Product(104, "Data Science Book", 899.0, "Books"));

        // Simulated user search
        String keyword = "samsung";
        double minPrice = 10000;
        double maxPrice = 50000;
        String category = "electronics";

        List<Product> results = searchEngine.search(keyword, minPrice, maxPrice, category);

        System.out.println("Search Results:");
        for (Product p : results) {
            System.out.println(p);
        }
    }
}
