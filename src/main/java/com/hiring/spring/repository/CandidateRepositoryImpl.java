package com.hiring.spring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.hiring.spring.bean.Candidate;
import com.hiring.spring.bean.FeedBack;
import com.hiring.spring.bean.Interview;
import org.springframework.stereotype.Repository;

/**
 * Created by Theodore on 7/9/2017.
 */
@Repository("candidateRepository")
public class CandidateRepositoryImpl implements CandidateRepository {
    private static AtomicInteger ID_GENERATOR =  new AtomicInteger();
    private ConcurrentHashMap<Integer, Candidate> candidateMap;


    public CandidateRepositoryImpl() {
        candidateMap = new ConcurrentHashMap<>();
    }

    @Override
    public List<Candidate> findAll() {
        List<Candidate> list = new ArrayList<>(candidateMap.values());
        return list;
    }

    @Override
    public Candidate findCandidate(Integer key) {
        Candidate candidate = candidateMap.get(key);
        return candidate;
    }

    @Override
    public void add(Candidate candidate) {
        int candidateId = ID_GENERATOR.getAndIncrement();
        candidate.setId(candidateId);
        candidateMap.put(candidateId, candidate);
    }

    @Override
    public void delete(Integer key) {
        candidateMap.remove(key);
    }

    @Override
    public void addInterview(Interview interview) {
        Integer key = Integer.valueOf(interview.getKey());
        Candidate candidate = findCandidate(key);
        candidate.addInterview(interview);
    }

    @Override
    public void addFeedBack(FeedBack feedBack) {
        Integer key = Integer.valueOf(feedBack.getKey());
        Candidate candidate = findCandidate(key);
        candidate.addFeedBack(feedBack);
    }
}
