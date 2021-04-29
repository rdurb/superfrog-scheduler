package tcu.webtech.superfrogscheduler.models;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String date;

    private String startTime;

    private String endTime;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private String requestingUserEmail;

    private String assignedSuperFrogEmail;

    public Event() {}

    public Event(String requestingUserEmail, String title, String description, String date, String startTime, String endTime) {
        this.requestingUserEmail = requestingUserEmail;
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = EventStatus.PENDING;
        this.assignedSuperFrogEmail = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //public Date getDate() {
//        return date;
//    }

    //public void setDate(Date date) {
//        this.date = date;
//    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public String getRequestingUserEmail() {
        return requestingUserEmail;
    }

    public void setRequestingUserEmail(String requestingUserEmail) {
        this.requestingUserEmail = requestingUserEmail;
    }

    public String getAssignedSuperFrogEmail() {
        return assignedSuperFrogEmail;
    }

    public void setAssignedSuperFrogEmail(String assignedSuperFrogEmail) {
        this.assignedSuperFrogEmail = assignedSuperFrogEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
