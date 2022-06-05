package com.guild.backend.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.guild.backend.entity.Job;
import com.guild.backend.repo.JobRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class JobService {
    private final JobRepo jobRepo;

    public Job create(Job job){
        log.info("Creating new job: {}", job.getTitle());
        return jobRepo.save(job);
    }

    public Collection<Job> list(int limit){
        log.info("Featching all jobs with limit: {}", limit);
        return jobRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    public Job get(Long id){
        log.info("Featching job with id: {}", id);
        return jobRepo.findById(id).get();
    }

    public Job update(Job job){
        log.info("Updating job id: {}", job.getId());
        Job exJob = jobRepo.findById(job.getId()).get();
        if (job.getAdventurer_id() != null) exJob.setAdventurer_id(job.getAdventurer_id());
        if (job.getDescription() != null) exJob.setDescription(job.getDescription());
        if (job.getImage() != null) exJob.setImage(job.getImage());
        if (job.getImage() != null) exJob.setLocation(job.getLocation());
        if (job.getRank() != null) exJob.setRank(job.getRank());
        if (job.getReward() > 0) exJob.setReward(job.getReward());
        if (job.getStatus() != null) exJob.setStatus(job.getStatus());
        if (job.getTitle() != null) exJob.setTitle(job.getTitle());
        return jobRepo.save(exJob);
    }

    public boolean delete(Long id){
        log.info("Deleting job by id:{}", id);
        jobRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
