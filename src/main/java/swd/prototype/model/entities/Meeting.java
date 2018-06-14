package swd.prototype.model.entities;

import java.util.Date;

public class Meeting {

    private int meetingId;
    private String title;
    private String subject;
    private String details;
    private Date dateTime;
    private int customerFK;

    public Meeting(){

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCustomerFK() {
        return customerFK;
    }

    public void setCustomerFK(int customerFK) {
        this.customerFK = customerFK;
    }
}
