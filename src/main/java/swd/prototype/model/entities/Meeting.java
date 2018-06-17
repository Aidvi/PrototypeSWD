package swd.prototype.model.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Meeting {

    private int meetingId;
    private String title;
    private String subject;
    private String details;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date end;


    public Meeting(int meetingId, String title, String subject, String details, Date start, Date end) {
        this.meetingId = meetingId;
        this.title = title;
        this.subject = subject;
        this.details = details;
        this.start = start;
        this.end = end;
    }

    public Meeting() {

    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + meetingId +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", details='" + details + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

