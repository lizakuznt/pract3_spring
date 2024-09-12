package com.mpt.journal.service;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.repository.SubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubServiceImpl implements SubService {

    private final SubRepository repository;

    public SubServiceImpl(SubRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SubModel> findAllSub() {
        return repository.findAll();
    }

    @Override
    public SubModel createSub(SubModel sub) {
        return repository.save(sub);
    }

    @Override
    public SubModel updateSub(SubModel sub) {
        return repository.save(sub);
    }

    @Override
    public SubModel findSubById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteSub(Long id) {
        repository.deleteById(id);
    }
}
