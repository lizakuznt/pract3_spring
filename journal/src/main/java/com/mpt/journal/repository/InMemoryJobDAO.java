package com.mpt.journal.repository;

import com.mpt.journal.model.JobModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryJobDAO{
    private final List<JobModel> JOBS = new ArrayList<>();

    public List<JobModel> findAllJob() {
        return JOBS;
    }

    public JobModel findJobById(Long id) {
        return JOBS
                .stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public JobModel createJob(JobModel job) {
        JOBS.add(job);
        return job;
    }

    public JobModel updateJob(JobModel job) {
        var jobIndex = IntStream.range(0, JOBS.size())
                .filter(index -> JOBS.get(index).getId().equals(job.getId()))
                .findFirst()
                .orElse(-1);
        if (jobIndex == -1) {
            return null;
        }
        JOBS.set(jobIndex, job);
        return job;
    }

    public void deleteJob(Long id) {
        var job = findJobById(id);
        if (job != null) {
            JOBS.remove(job);
        }
    }
}
