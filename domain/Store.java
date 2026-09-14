package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a store within a warehouse — a named grouping of locations
 * used to organise similar types of products.
 */
public class Store {

    private final String storeId;
    private final Warehouse warehouse;
    private final List<Location> locations;
    private String storeName;

    public Store(String storeId, Warehouse warehouse) {
        if (storeId == null || storeId.isBlank()) {
            throw new IllegalArgumentException("Store ID must not be blank");
        }
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse must not be null");
        }
        this.storeId = storeId;
        this.warehouse = warehouse;
        this.locations = new ArrayList<>();
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * Adds a location to this store.
     */
    public void addLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location must not be null");
        }
        locations.add(location);
    }

    /**
     * Removes a location from this store. Returns true if the location was present.
     */
    public boolean removeLocation(Location location) {
        return locations.remove(location);
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(locations);
    }

    /**
     * Returns the total capacity across all locations in this store.
     */
    public int getTotalCapacity() {
        return locations.stream().mapToInt(Location::getCapacity).sum();
    }

    public int getLocationCount() {
        return locations.size();
    }
}
