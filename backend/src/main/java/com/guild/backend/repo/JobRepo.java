package com.guild.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guild.backend.entity.Job;

import java.util.List;

public interface JobRepo extends JpaRepository<Job, Long> {
//    List<Job> findByAdventurer_idAndDate_acceptedIsNotNull(Long id);

}
