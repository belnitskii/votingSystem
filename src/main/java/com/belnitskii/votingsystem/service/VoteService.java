package com.belnitskii.votingsystem.service;

import com.belnitskii.votingsystem.model.Vote;
import com.belnitskii.votingsystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote createVote(Vote vote){
        return voteRepository.save(vote);
    }

    public List<Vote> getAllVotes(){
        return voteRepository.findAll();
    }

    public Vote getVoteById(Long id){
        return voteRepository.findById(id).orElse(null);
    }
}
