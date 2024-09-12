package com.mpt.journal.controller;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.service.JobService;
import com.mpt.journal.service.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/job")
public class JobApiController {

    private final JobService jobService;

    public JobApiController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobModel> getAllJobs() {
        return jobService.findAllJob();
    }

    @PostMapping
    public JobModel createJob(@RequestBody JobModel job) {
        return jobService.createJob(job);
    }

    @DeleteMapping
    public void deleteJob(@RequestBody JobModel job) {
        jobService.deleteJob(job.getId());
        return;
    }
}