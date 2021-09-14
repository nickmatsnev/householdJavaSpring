package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "public", catalog = "household_project_db")
public class UserEntity {
    private String fullName;
    private String email;
    private String password;
    private Integer dob;
    private Integer userId;

    public UserEntity() {
    }

    public UserEntity(String fullName, String email, String password, Integer userID, Integer age) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userId = userID;
        this.dob = age;
    }

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Basic
    @Column(name = "FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Age")
    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }

    @GeneratedValue
    @Id
    @Column(name = "UserID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (!Objects.equals(fullName, that.fullName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        return Objects.equals(dob, that.dob);
    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
