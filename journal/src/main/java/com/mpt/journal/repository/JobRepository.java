package com.mpt.journal.repository;

import com.mpt.journal.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobModel, Long> {
}
