package com.hiring.spring.bean;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * Created by Theodore on 7/8/2017.
 */
public class Candidate {
    private Integer id;

    @Size(min = 3, max = 30, message = "First Name must between 3 and 30 characters")
    private String firstName;

    @Size(min = 3, max = 30, message = "Last Name must between 3 and 30 characters")
    private String lastName;

    private List<Interview> interviewList;

    private List<FeedBack> feedBackList;


    public Candidate() {
        interviewList = new ArrayList<>();
        feedBackList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addInterview(Interview interview) {
        interviewList.add(interview);
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void addFeedBack(FeedBack feedBack) {
        feedBackList.add(feedBack);
    }

    public List<FeedBack> getFeedBackList() {
        return feedBackList;
    }
}
