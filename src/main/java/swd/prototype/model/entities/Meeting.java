package swd.prototype.model.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Meeting {

    private int meetingId;
    private String title;
    private String subject;
    private String details;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date endDate;
    private int customerFK;

    public Meeting(String title, String subject, String details, Date startDate, Date endDate, int customerFK) {
        this.title = title;
        this.subject = subject;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerFK = customerFK;
    }
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCustomerFK() {
        return customerFK;
    }

    public void setCustomerFK(int customerFK) {
        this.customerFK = customerFK;
    }
}