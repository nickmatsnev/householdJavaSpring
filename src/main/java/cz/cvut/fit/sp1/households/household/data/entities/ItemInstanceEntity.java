package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ItemInstance", schema = "public", catalog = "household_project_db")
public class ItemInstanceEntity {
    private Timestamp boughtDate;
    private Timestamp expirationDate;
    private BigDecimal percentLeft;
    private String quantityType;
    private int itemInstanceId;
    private int inventoryItemId;
    private Integer locationId;

    @Basic
    @Column(name = "BOUGHT DATE")
    public Timestamp getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Timestamp boughtDate) {
        this.boughtDate = boughtDate;
    }

    @Basic
    @Column(name = "ExpirationDate")
    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "PercentLeft")
    public BigDecimal getPercentLeft() {
        return percentLeft;
    }

    public void setPercentLeft(BigDecimal percentLeft) {
        this.percentLeft = percentLeft;
    }

    @Basic
    @Column(name = "QuantityType")
    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

    @Id
    @Column(name = "ItemInstanceID")
    public int getItemInstanceId() {
        return itemInstanceId;
    }

    public void setItemInstanceId(int itemInstanceId) {
        this.itemInstanceId = itemInstanceId;
    }

    @Basic
    @Column(name = "InventoryItemID")
    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    @Basic
    @Column(name = "LocationID")
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemInstanceEntity that = (ItemInstanceEntity) o;

        if (itemInstanceId != that.itemInstanceId) return false;
        if (inventoryItemId != that.inventoryItemId) return false;
        if (boughtDate != null ? !boughtDate.equals(that.boughtDate) : that.boughtDate != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        if (percentLeft != null ? !percentLeft.equals(that.percentLeft) : that.percentLeft != null) return false;
        if (quantityType != null ? !quantityType.equals(that.quantityType) : that.quantityType != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = boughtDate != null ? boughtDate.hashCode() : 0;
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (percentLeft != null ? percentLeft.hashCode() : 0);
        result = 31 * result + (quantityType != null ? quantityType.hashCode() : 0);
        result = 31 * result + itemInstanceId;
        result = 31 * result + inventoryItemId;
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        return result;
    }
}
