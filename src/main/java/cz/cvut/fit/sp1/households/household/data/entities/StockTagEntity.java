package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "StockTag", schema = "public", catalog = "household_project_db")
public class StockTagEntity {
    private String colour;
    private String name;
    private int stockTagId;
    private int householdId;

    @Basic
    @Column(name = "Colour")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "StockTagID")
    public int getStockTagId() {
        return stockTagId;
    }

    public void setStockTagId(int stockTagId) {
        this.stockTagId = stockTagId;
    }

    @Basic
    @Column(name = "HouseholdID")
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockTagEntity that = (StockTagEntity) o;

        if (stockTagId != that.stockTagId) return false;
        if (householdId != that.householdId) return false;
        if (colour != null ? !colour.equals(that.colour) : that.colour != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = colour != null ? colour.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + stockTagId;
        result = 31 * result + householdId;
        return result;
    }
}
