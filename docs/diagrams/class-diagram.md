# Class Diagram

```mermaid
classDiagram
    class Location {
        -String address
        +Location(String address)
        +getAddress() String
        +toString() String
    }

    class Warehouse {
        -String warehouseId
        -Location location
        -Map~String, Integer~ stockLevels
        -int capacity
        -String warehouseName
        +Warehouse(String warehouseId, Location location, int capacity)
        +getWarehouseId() String
        +getLocation() Location
        +getCapacity() int
        +setCapacity(int capacity) void
        +receiveStock(String sku, int quantity) void
        +dispatchStock(String sku, int quantity) void
        +getStockLevel(String sku) int
        +getTotalStock() int
        +isAtCapacity() boolean
    }

    Warehouse --> Location : location
```
