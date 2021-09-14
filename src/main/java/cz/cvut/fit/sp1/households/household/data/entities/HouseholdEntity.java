package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Household", schema = "public", catalog = "postgres")
public class HouseholdEntity {
    private String address;
    private String name;
    private int householdId;

    public HouseholdEntity() {
    }

    public HouseholdEntity(String address, String name, int householdId) {
        this.address = address;
        this.name = name;
        this.householdId = householdId;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @GeneratedValue
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

        HouseholdEntity that = (HouseholdEntity) o;

        if (householdId != that.householdId) return false;
        if (!Objects.equals(address, that.address)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + householdId;
        return result;
    }
}
