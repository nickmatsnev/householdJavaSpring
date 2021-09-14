package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Member", schema = "public", catalog = "household_project_db")
public class MemberEntity {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String membershipType;
    private int memberId;
    private int householdId;
    private int userId;



    public MemberEntity() {
    }

    public MemberEntity(String membershipType, int householdId, int userId) {
        this.membershipType = membershipType;
        this.memberId = count.incrementAndGet();
        this.householdId = householdId;
        this.userId = userId;
    }

    @Basic
    @Column(name = "MembershipType")
    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    @GeneratedValue
    @Id
    @Column(name = "MemberID")
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "HouseholdID")
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Basic
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberEntity that = (MemberEntity) o;

        if (memberId != that.memberId) return false;
        if (householdId != that.householdId) return false;
        if (userId != that.userId) return false;
        if (membershipType != null ? !membershipType.equals(that.membershipType) : that.membershipType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = membershipType != null ? membershipType.hashCode() : 0;
        result = 31 * result + memberId;
        result = 31 * result + householdId;
        result = 31 * result + userId;
        return result;
    }
}
