package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TrackingEntryEntityPK implements Serializable {
    private int trackingEntryId;
    private int trackingCategoryId;

    @Column(name = "TrackingEntryID")
    @Id
    public int getTrackingEntryId() {
        return trackingEntryId;
    }

    public void setTrackingEntryId(int trackingEntryId) {
        this.trackingEntryId = trackingEntryId;
    }

    @Column(name = "TrackingCategoryID")
    @Id
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

        TrackingEntryEntityPK that = (TrackingEntryEntityPK) o;

        if (trackingEntryId != that.trackingEntryId) return false;
        if (trackingCategoryId != that.trackingCategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackingEntryId;
        result = 31 * result + trackingCategoryId;
        return result;
    }
}
