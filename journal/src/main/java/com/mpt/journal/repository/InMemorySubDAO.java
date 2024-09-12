package com.mpt.journal.repository;

import com.mpt.journal.model.SubModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemorySubDAO {
    private final List<SubModel> SUBS = new ArrayList<>();

    public List<SubModel> findAllSub() {
        return SUBS;
    }

    public SubModel findSubById(Long id) {
        return SUBS
                .stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public SubModel createSub(SubModel sub) {
        SUBS.add(sub);
        return sub;
    }

    public SubModel updateSub(SubModel sub) {
        var subIndex = IntStream.range(0, SUBS.size())
                .filter(index -> SUBS.get(index).getId().equals(sub.getId()))
                .findFirst()
                .orElse(-1);
        if (subIndex == -1) {
            return null;
        }
        SUBS.set(subIndex, sub);
        return sub;
    }

    public void deleteSub(Long id) {
        var sub = findSubById(id);
        if (sub != null) {
            SUBS.remove(sub);
        }
    }
}
