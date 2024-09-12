package com.mpt.journal.repository;

import com.mpt.journal.model.SubModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository<SubModel, Long> {
}
