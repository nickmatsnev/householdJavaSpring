package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Invitation", schema = "public", catalog = "household_project_db")
public class InvitationEntity {
    private int userId;
    private int receiverId;
    private int invitationId;
    private int householdId;
    private static final AtomicInteger count = new AtomicInteger(0);

    public InvitationEntity() {
    }

    public InvitationEntity(int userId, int householdId, int receiverId) {
        this.userId = userId;
        this.householdId = householdId;
        this.invitationId = count.incrementAndGet();
        this.receiverId = receiverId;
    }
    @Basic
    @Column(name = "receiverId")
    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @GeneratedValue
    @Id
    @Column(name = "invitationID")
    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    @Basic
    @Column(name = "householdID")
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
        InvitationEntity that = (InvitationEntity) o;
        return userId == that.userId && invitationId == that.invitationId && householdId == that.householdId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, invitationId, householdId);
    }
}
