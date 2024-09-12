package com.mpt.journal.service;

import com.mpt.journal.model.JobModel;

import java.util.List;

public interface JobService {
    List<JobModel> findAllJob();
    JobModel createJob(JobModel job);
    JobModel updateJob(JobModel job);
    JobModel findJobById(Long id);
    void deleteJob(Long id);
}