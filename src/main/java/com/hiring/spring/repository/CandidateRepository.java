package com.hiring.spring.repository;

import java.util.List;

import com.hiring.spring.bean.Candidate;
import com.hiring.spring.bean.FeedBack;
import com.hiring.spring.bean.Interview;

/**
 * Created by Theodore on 7/9/2017.
 */
public interface CandidateRepository {
    List<Candidate> findAll();
    Candidate findCandidate(Integer key);
    void add(Candidate candidate);
    void delete(Integer key);
    void addInterview(Interview interview);
    void addFeedBack(FeedBack feedBack);
}
