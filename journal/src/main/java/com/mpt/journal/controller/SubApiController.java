package com.mpt.journal.controller;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.service.SubService;
import com.mpt.journal.service.SubServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/sub")
public class SubApiController {

    private final SubService subService;

    public SubApiController(SubServiceImpl subService) {
        this.subService = subService;
    }

    @GetMapping
    public List<SubModel> getAllSubs() {
        return subService.findAllSub();
    }

    @PostMapping
    public SubModel createSub(@RequestBody SubModel sub) {
        return subService.createSub(sub);
    }

    @DeleteMapping
    public void deleteSub(@RequestBody SubModel sub) {
        subService.deleteSub(sub.getId());
        return;
    }
}
