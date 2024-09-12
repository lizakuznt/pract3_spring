package com.mpt.journal.service;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.repository.InMemorySubDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemorySubImpl implements SubService {

    private final InMemorySubDAO subRepository;

    public InMemorySubImpl(InMemorySubDAO subRepository) {
        this.subRepository = subRepository;
    }

    @Override
    public List<SubModel> findAllSub() {
        return subRepository.findAllSub();
    }

    @Override
    public SubModel createSub(SubModel sub) {
        return subRepository.createSub(sub);
    }

    @Override
    public SubModel updateSub(SubModel sub) {
        return subRepository.updateSub(sub);
    }

    @Override
    public SubModel findSubById(Long id) {
        return subRepository.findSubById(id);
    }

    @Override
    public void deleteSub(Long id) {
        subRepository.deleteSub(id);
    }
}
