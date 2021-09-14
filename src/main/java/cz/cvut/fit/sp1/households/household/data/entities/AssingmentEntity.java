package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "Assingment", schema = "public", catalog = "household_project_db")
public class AssingmentEntity {
    private int stockTagId;
    private int inventoryItemId;

    @Id
    @Basic
    @Column(name = "StockTagID")
    public int getStockTagId() {
        return stockTagId;
    }

    public void setStockTagId(int stockTagId) {
        this.stockTagId = stockTagId;
    }

    @Basic
    @Column(name = "InventoryItemID")
    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssingmentEntity that = (AssingmentEntity) o;

        if (stockTagId != that.stockTagId) return false;
        if (inventoryItemId != that.inventoryItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockTagId;
        result = 31 * result + inventoryItemId;
        return result;
    }
}
