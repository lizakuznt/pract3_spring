package com.mpt.journal.service;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository repository;

    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<JobModel> findAllJob() {
        return repository.findAll();
    }

    @Override
    public JobModel createJob(JobModel job) {
        return repository.save(job);
    }

    @Override
    public JobModel updateJob(JobModel job) {
        return repository.save(job);
    }

    @Override
    public JobModel findJobById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteJob(Long id) {
        repository.deleteById(id);
    }
}
