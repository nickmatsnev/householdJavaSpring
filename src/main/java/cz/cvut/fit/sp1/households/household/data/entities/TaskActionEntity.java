package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "TaskAction", schema = "public", catalog = "household_project_db")
public class TaskActionEntity {
    private Timestamp dateTime;
    private Time description;
    private String performedBy;
    private int taskActionId;
    private int taskId;

    @Basic
    @Column(name = "DateTime")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "Description")
    public Time getDescription() {
        return description;
    }

    public void setDescription(Time description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PerformedBy")
    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    @Id
    @Column(name = "TaskActionID")
    public int getTaskActionId() {
        return taskActionId;
    }

    public void setTaskActionId(int taskActionId) {
        this.taskActionId = taskActionId;
    }

    @Basic
    @Column(name = "TaskID")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskActionEntity that = (TaskActionEntity) o;

        if (taskActionId != that.taskActionId) return false;
        if (taskId != that.taskId) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (performedBy != null ? !performedBy.equals(that.performedBy) : that.performedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateTime != null ? dateTime.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (performedBy != null ? performedBy.hashCode() : 0);
        result = 31 * result + taskActionId;
        result = 31 * result + taskId;
        return result;
    }
}
