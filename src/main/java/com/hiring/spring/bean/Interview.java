package com.hiring.spring.bean;

import java.util.Date;

/**
 * Created by Theodore on 7/10/2017.
 */
public class Interview {
    private String key;
    private String interviewerFirstName;
    private String interviewerLastName;
    private String startDate;
    private String startTime;
    private Date startDateTime;
    private Date endDate;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInterviewerFirstName() {
        return interviewerFirstName;
    }

    public void setInterviewerFirstName(String interviewerFirstName) {
        this.interviewerFirstName = interviewerFirstName;
    }

    public String getInterviewerLastName() {
        return interviewerLastName;
    }

    public void setInterviewerLastName(String interviewerLastName) {
        this.interviewerLastName = interviewerLastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
