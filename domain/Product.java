package domain;

import java.math.BigDecimal;

/**
 * Represents a product that can be stored within a warehouse.
 */
public class Product {

    private final String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String sku;

    public Product(String productId, String name, String sku) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Product ID must not be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must not be blank");
        }
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU must not be blank");
        }
        this.productId = productId;
        this.name = name;
        this.sku = sku;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
