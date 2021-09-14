package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "InventoryItem", schema = "public", catalog = "postgres")
public class InventoryItemEntity {
    private String description;
    private String title;
    private int inventoryItemId;
    private Integer categoryId;

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Id
    @Column(name = "InventoryItemID")
    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    @Basic
    @Column(name = "CategoryID")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryItemEntity that = (InventoryItemEntity) o;

        if (inventoryItemId != that.inventoryItemId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + inventoryItemId;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }
}
