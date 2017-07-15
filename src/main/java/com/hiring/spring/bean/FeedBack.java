package com.hiring.spring.bean;

import java.util.Date;

/**
 * Created by Theodore on 7/10/2017.
 */
public class FeedBack {
    private String key;
    private Date feedBackDate;
    private String feedback;

    public FeedBack() {
        feedback = "";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getFeedBackDate() {
        return feedBackDate;
    }

    public void setFeedBackDate(Date feedBackDate) {
        this.feedBackDate = feedBackDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
