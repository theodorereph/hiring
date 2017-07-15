package com.hiring.spring.service;

import java.util.Date;
import java.util.List;

import com.hiring.spring.bean.Candidate;
import com.hiring.spring.bean.FeedBack;
import com.hiring.spring.bean.Interview;
import com.hiring.spring.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Theodore on 7/9/2017.
 */
@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> add(Candidate candidate) {
        candidateRepository.add(candidate);
        List<Candidate> candidateList = findAll();
        return candidateList;
    }

    @Override
    public List<Candidate> findAll() {
       List<Candidate> candidateList = candidateRepository.findAll();
       return candidateList;
    }

    @Override
    public Candidate findCandidate(String id) {
        Integer key = Integer.valueOf(id);
        Candidate candidate = candidateRepository.findCandidate(key);
        return candidate;

    }

    @Override
    public List<Candidate> delete(String id) {
        Integer key = Integer.valueOf(id);
        candidateRepository.delete(key);
        List<Candidate> candidateList = findAll();
        return candidateList;
    }

    @Override
    public Candidate addInterview(Interview interview) {
        candidateRepository.addInterview(interview);
        Integer key = Integer.valueOf(interview.getKey());
        Candidate candidate = candidateRepository.findCandidate(key);
        return candidate;
    }

    @Override
    public Candidate addFeedBack(FeedBack feedBack) {
        feedBack.setFeedBackDate(new Date());
        candidateRepository.addFeedBack(feedBack);
        Integer key = Integer.valueOf(feedBack.getKey());
        Candidate candidate = candidateRepository.findCandidate(key);
        return candidate;
    }
}
