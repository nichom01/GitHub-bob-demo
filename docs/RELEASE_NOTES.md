# Release Notes


## 2026-09-14 (PR: feat: implement issue #3)

### Add `Store` class — named grouping of `Location`s within a `Warehouse`

**`domain/Store.java`** *(new)*
- Added `Store` class representing a named grouping of locations within a warehouse.
- Fields: `storeId` (`private final String`), `warehouse` (`private final Warehouse`), `locations` (`private final List<Location>`), `storeName` (`private String`).
- Constructor validates that `storeId` is non-blank and `warehouse` is non-null.
- `addLocation(Location)` appends a location (null guard enforced).
- `removeLocation(Location)` removes a location and returns a `boolean` indicating whether it was present.
- `getLocations()` returns an unmodifiable view of the location list.
- `getTotalCapacity()` sums `getCapacity()` across all locations.
- `getLocationCount()` returns the number of locations in the store.

---


## 2026-09-14

### Extract `Location` class; delegate capacity to `Location`; refactor `Warehouse`

**`domain/Location.java`** *(new)*
- Added `Location` value class representing a warehouse's physical address and capacity.
- Fields: `address` (`private final String`), `capacity` (`private int`).
- Constructor validates that `address` is non-blank and `capacity` is positive.
- Exposes `getAddress() String`, `getCapacity() int`, `setCapacity(int) void` (with positive-value guard), and overrides `toString()` to return the address.

**`domain/Warehouse.java`**
- Changed `location` field type from `String` to `Location`.
- Constructor signature changed from `(String warehouseId, String location, int capacity)` to `(String warehouseId, Location location)` — capacity is now owned by `Location`.
- Removed standalone `capacity` field; `getCapacity()`, `setCapacity()`, `receiveStock()`, and `isAtCapacity()` now delegate to `location.getCapacity()` / `location.setCapacity()`.
- `getLocation()` return type updated from `String` to `Location`.
- Added `warehouseName` field (`private String`).
