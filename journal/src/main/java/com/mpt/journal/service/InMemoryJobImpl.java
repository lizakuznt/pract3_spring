package com.mpt.journal.service;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.repository.InMemoryJobDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryJobImpl implements JobService {

    private final InMemoryJobDAO jobRepository;

    public InMemoryJobImpl(InMemoryJobDAO jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobModel> findAllJob() {
        return jobRepository.findAllJob();
    }

    @Override
    public JobModel createJob(JobModel job) {
        return jobRepository.createJob(job);
    }

    @Override
    public JobModel updateJob(JobModel job) {
        return jobRepository.updateJob(job);
    }

    @Override
    public JobModel findJobById(Long id) {
        return jobRepository.findJobById(id);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteJob(id);
    }
}
