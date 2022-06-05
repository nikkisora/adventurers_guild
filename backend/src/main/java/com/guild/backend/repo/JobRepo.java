package com.guild.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guild.backend.entity.Job;

public interface JobRepo extends JpaRepository<Job, Long> {

}
