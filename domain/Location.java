package domain;

/**
 * Represents the physical location of a warehouse.
 */
public class Location {

    private final String address;

    public Location(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be blank");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return address;
    }
}
