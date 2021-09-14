package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TrackingEntry", schema = "public", catalog = "household_project_db")
@IdClass(TrackingEntryEntityPK.class)
public class TrackingEntryEntity {
    private String bill;
    private String consumption;
    private Timestamp entryDate;
    private int trackingEntryId;
    private int trackingCategoryId;

    @Basic
    @Column(name = "Bill")
    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    @Basic
    @Column(name = "Consumption")
    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    @Basic
    @Column(name = "EntryDate")
    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    @Id
    @Column(name = "TrackingEntryID")
    public int getTrackingEntryId() {
        return trackingEntryId;
    }

    public void setTrackingEntryId(int trackingEntryId) {
        this.trackingEntryId = trackingEntryId;
    }

    @Id
    @Column(name = "TrackingCategoryID")
    public int getTrackingCategoryId() {
        return trackingCategoryId;
    }

    public void setTrackingCategoryId(int trackingCategoryId) {
        this.trackingCategoryId = trackingCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackingEntryEntity that = (TrackingEntryEntity) o;

        if (trackingEntryId != that.trackingEntryId) return false;
        if (trackingCategoryId != that.trackingCategoryId) return false;
        if (bill != null ? !bill.equals(that.bill) : that.bill != null) return false;
        if (consumption != null ? !consumption.equals(that.consumption) : that.consumption != null) return false;
        if (entryDate != null ? !entryDate.equals(that.entryDate) : that.entryDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bill != null ? bill.hashCode() : 0;
        result = 31 * result + (consumption != null ? consumption.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + trackingEntryId;
        result = 31 * result + trackingCategoryId;
        return result;
    }
}
