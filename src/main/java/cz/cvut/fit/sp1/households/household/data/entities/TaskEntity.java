package cz.cvut.fit.sp1.households.household.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Task", schema = "public", catalog = "household_project_db")
public class TaskEntity {
    private Timestamp deadline;
    private String description;
    private String priority;
    private String state;
    private String title;
    private String type;
    private int taskId;
    private int authorid;
    private Integer assigneeid;

    @Basic
    @Column(name = "Deadline")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Id
    @Column(name = "TaskID")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "AUTHORID")
    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    @Basic
    @Column(name = "ASSIGNEEID")
    public Integer getAssigneeid() {
        return assigneeid;
    }

    public void setAssigneeid(Integer assigneeid) {
        this.assigneeid = assigneeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (taskId != that.taskId) return false;
        if (authorid != that.authorid) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (assigneeid != null ? !assigneeid.equals(that.assigneeid) : that.assigneeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deadline != null ? deadline.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + taskId;
        result = 31 * result + authorid;
        result = 31 * result + (assigneeid != null ? assigneeid.hashCode() : 0);
        return result;
    }
}
