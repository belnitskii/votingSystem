package com.belnitskii.votingsystem.repository;

import com.belnitskii.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {


}
