# Release Notes

## 2026-09-14

### Extract `Location` class; refactor `Warehouse` location field

**`domain/Location.java`** *(new)*
- Added `Location` value class representing a warehouse's physical address.
- Single `address` field (`private final String`), validated non-blank in constructor.
- Exposes `getAddress() String` and overrides `toString()`.

**`domain/Warehouse.java`**
- Changed `location` field type from `String` to `Location`.
- Constructor signature updated to accept a `Location` instead of a raw `String`.
- `getLocation()` return type updated from `String` to `Location`.
- `warehouseName` field (`private String`) added to the class.
