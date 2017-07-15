package com.hiring.spring.service;

import java.util.List;

import com.hiring.spring.bean.Candidate;
import com.hiring.spring.bean.FeedBack;
import com.hiring.spring.bean.Interview;

/**
 * Created by Theodore on 7/9/2017.
 */
public interface CandidateService {
    List<Candidate> findAll();
    Candidate findCandidate(String id);
    List<Candidate> add(Candidate candidate);
    List<Candidate> delete(String id);
    Candidate addInterview(Interview interview);
    Candidate addFeedBack(FeedBack feedBack);
}
