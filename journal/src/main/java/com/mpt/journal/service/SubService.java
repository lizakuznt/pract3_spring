package com.mpt.journal.service;

import com.mpt.journal.model.SubModel;

import java.util.List;

public interface SubService {
    List<SubModel> findAllSub();
    SubModel createSub(SubModel sub);
    SubModel updateSub(SubModel sub);
    SubModel findSubById(Long id);
    void deleteSub(Long id);
}