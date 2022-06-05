package com.guild.backend.controller;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.backend.entity.Job;
import com.guild.backend.service.JobService;

import exceptions.Response;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobsController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<Response> list(){
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("jobs", jobService.list(30)))
                    .message("Jobs retrieved")
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getOneJob(@PathVariable Long id){
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("job", jobService.get(id)))
                    .message(String.format("Job with id {%d} retrieved", id))
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @PostMapping
    public ResponseEntity<Response> createJob(@RequestBody @Valid Job job){
        job.setCustomer_id(Long.valueOf(2));
        job.setStatus("in review");
        job.setDate_added(LocalDateTime.now());

        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("job", jobService.create(job)))
                    .message("Job created")
                    .status(HttpStatus.CREATED)
                    .statusCode(HttpStatus.CREATED.value())
                    .build()
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> updateJob(@PathVariable Long id, @RequestBody Job job){
        job.setId(id);
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("deleted", jobService.update(job)))
                    .message(String.format("Updated job with id {%d}", id))
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response> deleteJob(@PathVariable Long id){
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("deleted", jobService.delete(id)))
                    .message(String.format("Deleted job with id {%d}", id))
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

}
