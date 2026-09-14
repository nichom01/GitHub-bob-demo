package domain;

/**
 * Represents the physical location of a warehouse.
 */
public class Location {

    private final String address;
    private int capacity;

    public Location(String address, int capacity) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be blank");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.address = address;
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return address;
    }
}
