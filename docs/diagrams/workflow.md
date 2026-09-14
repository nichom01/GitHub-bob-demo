# Workflow

```mermaid
flowchart TD
    subgraph locationNew[new Location]
        L1[Validate address not blank] -->|blank| L2[throw IllegalArgumentException]
        L1 -->|valid| L3[Validate capacity > 0] -->|invalid| L4[throw IllegalArgumentException]
        L3 -->|valid| L5[Assign address and capacity fields]
    end

    subgraph locationSetCapacity[Location.setCapacity]
        SC1[Validate capacity > 0] -->|invalid| SC2[throw IllegalArgumentException]
        SC1 -->|valid| SC3[Assign capacity field]
    end

    subgraph receiveStock[Warehouse.receiveStock]
        RS1[Validate quantity > 0] -->|invalid| RS2[throw IllegalArgumentException]
        RS1 -->|valid| RS3[Read current stock for SKU]
        RS3 --> RS4["Add quantity, capped at location.getCapacity()"]
        RS4 --> RS5[Write updated level to stockLevels]
    end

    subgraph dispatchStock[Warehouse.dispatchStock]
        DS1[Validate quantity > 0 and ≤ current stock] -->|invalid| DS2[throw IllegalStateException]
        DS1 -->|valid| DS3[Subtract quantity from stockLevels]
    end

    subgraph isAtCapacity[Warehouse.isAtCapacity]
        IAC1[getTotalStock] --> IAC2{"≥ location.getCapacity()?"}
        IAC2 -->|yes| IAC3[return true]
        IAC2 -->|no| IAC4[return false]
    end
```
