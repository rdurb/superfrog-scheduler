package tcu.webtech.superfrogscheduler.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    //@DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private String date;

    private String startTime;

    private String endTime;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private Long requestingUserId;

    private Long assignedSuperFrogId;

    public Event() {}

    public Event(Long requestingUserId, String title, String description, String date, String startTime, String endTime) {
        this.requestingUserId = requestingUserId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = EventStatus.PENDING;
    }

    public Long getId() {
        return id;
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

    public Long getRequestingUserId() {
        return requestingUserId;
    }

    public void setRequestingUserId(Long requestingUserId) {
        this.requestingUserId = requestingUserId;
    }

    public Long getAssignedSuperFrogId() {
        return assignedSuperFrogId;
    }

    public void setAssignedSuperFrogId(Long assignedSuperFrogId) {
        this.assignedSuperFrogId = assignedSuperFrogId;
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
