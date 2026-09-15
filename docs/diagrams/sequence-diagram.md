# Sequence Diagram

```mermaid
sequenceDiagram
    participant Caller
    participant Product
    participant Store
    participant Warehouse
    participant Location

    Note over Caller: Create a Product
    Caller->>Product: new Product(productId, name, sku)
    Product-->>Caller: product

    Caller->>Product: setPrice(price)
    Product-->>Caller: (price set)

    Caller->>Product: setDescription(description)
    Product-->>Caller: (description set)

    Note over Caller: Set up Location and Warehouse
    Caller->>Location: new Location(address, capacity)
    Location-->>Caller: location

    Caller->>Warehouse: new Warehouse(warehouseId, location)
    Warehouse-->>Caller: warehouse

    Note over Caller: Set up a Store within the Warehouse
    Caller->>Store: new Store(storeId, warehouse)
    Store-->>Caller: store

    Caller->>Store: setStoreName(name)
    Store-->>Caller: (name set)

    Note over Caller: Add locations to the Store
    Caller->>Store: addLocation(location)
    Store-->>Caller: (location added)

    Caller->>Store: getTotalCapacity()
    Store->>Location: getCapacity()
    Location-->>Store: capacity
    Store-->>Caller: totalCapacity

    Caller->>Store: getLocationCount()
    Store-->>Caller: count

    Note over Caller: Remove a location from the Store
    Caller->>Store: removeLocation(location)
    Store-->>Caller: boolean

    Note over Caller: Receive stock for a SKU
    Caller->>Warehouse: receiveStock(sku, quantity)
    Warehouse->>Location: getCapacity()
    Location-->>Warehouse: capacity
    Warehouse-->>Caller: (stock updated, capped at capacity)

    Note over Caller: Dispatch stock for a SKU
    Caller->>Warehouse: dispatchStock(sku, quantity)
    Warehouse-->>Caller: (stock reduced)

    Note over Caller: Query stock and capacity
    Caller->>Warehouse: getStockLevel(sku)
    Warehouse-->>Caller: level

    Caller->>Warehouse: getCapacity()
    Warehouse->>Location: getCapacity()
    Location-->>Warehouse: capacity
    Warehouse-->>Caller: capacity

    Caller->>Warehouse: isAtCapacity()
    Warehouse->>Warehouse: getTotalStock()
    Warehouse->>Location: getCapacity()
    Location-->>Warehouse: capacity
    Warehouse-->>Caller: boolean

    Note over Caller: Update capacity
    Caller->>Warehouse: setCapacity(newCapacity)
    Warehouse->>Location: setCapacity(newCapacity)
    Location-->>Warehouse: (capacity updated)
    Warehouse-->>Caller: (done)
```
