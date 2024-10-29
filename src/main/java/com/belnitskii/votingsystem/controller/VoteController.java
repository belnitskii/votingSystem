package com.belnitskii.votingsystem.controller;

import com.belnitskii.votingsystem.model.Vote;
import com.belnitskii.votingsystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        Vote createdVote = voteService.createVote(vote);
        return ResponseEntity.ok(createdVote);
    }

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteService.getAllVotes();
        return ResponseEntity.ok(votes);
    }
}