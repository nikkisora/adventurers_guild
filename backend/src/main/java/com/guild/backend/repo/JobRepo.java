package com.guild.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guild.backend.entity.Job;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepo extends JpaRepository<Job, Long> {
    List<Integer> findByAdventurerAndDate(Long i, Long j);

}
