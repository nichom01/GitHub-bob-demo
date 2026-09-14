package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single warehouse location and the stock it holds.
 *
 * This is intentionally minimal — it exists as a demo subject for the
 * doc-generation GitHub Action, which regenerates docs/RELEASE_NOTES.md
 * and the mermaid diagrams under docs/diagrams/ whenever this class changes.
 * 
 */

public class Warehouse {

    private final String warehouseId;
    private final Location location;
    private final Map<String, Integer> stockLevels;
    private int capacity;
    private String warehouseName;

    public Warehouse(String warehouseId, Location location, int capacity) {
        this.warehouseId = warehouseId;
        this.location = location;
        this.capacity = capacity;
        this.stockLevels = new HashMap<>();
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public Location getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds stock for a given SKU, capped by the warehouse's remaining capacity.
     */
    public void receiveStock(String sku, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        int current = stockLevels.getOrDefault(sku, 0);
        int updated = Math.min(current + quantity, capacity);
        stockLevels.put(sku, updated);
    }

    /**
     * Removes stock for a given SKU. Throws if there isn't enough on hand.
     */
    public void dispatchStock(String sku, int quantity) {
        int current = stockLevels.getOrDefault(sku, 0);
        if (quantity <= 0 || quantity > current) {
            throw new IllegalStateException("Cannot dispatch " + quantity + " units of " + sku);
        }
        stockLevels.put(sku, current - quantity);
    }

    public int getStockLevel(String sku) {
        return stockLevels.getOrDefault(sku, 0);
    }

    public int getTotalStock() {
        return stockLevels.values().stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isAtCapacity() {
        return getTotalStock() >= capacity;
    }
}
