package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TrackingCategory", schema = "public", catalog = "household_project_db")
public class TrackingCategoryEntity {
    private String category;
    private Timestamp startDate;
    private String timePeriod;
    private int trackingCategoryId;
    private int householdId;

    @Basic
    @Column(name = "Category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "StartDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "TimePeriod")
    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Id
    @Column(name = "TrackingCategoryID")
    public int getTrackingCategoryId() {
        return trackingCategoryId;
    }

    public void setTrackingCategoryId(int trackingCategoryId) {
        this.trackingCategoryId = trackingCategoryId;
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

        TrackingCategoryEntity that = (TrackingCategoryEntity) o;

        if (trackingCategoryId != that.trackingCategoryId) return false;
        if (householdId != that.householdId) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (timePeriod != null ? !timePeriod.equals(that.timePeriod) : that.timePeriod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (timePeriod != null ? timePeriod.hashCode() : 0);
        result = 31 * result + trackingCategoryId;
        result = 31 * result + householdId;
        return result;
    }
}
