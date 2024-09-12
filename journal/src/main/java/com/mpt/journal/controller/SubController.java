package com.mpt.journal.controller;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.service.SubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubController {

    @Qualifier("subServiceImpl")
    @Autowired
    private SubService subService;

    @GetMapping("/subs")
    public String getAllSubs(Model model) {
        List<SubModel> subs = subService.findAllSub();
        model.addAttribute("subs", subs);
        model.addAttribute("sub", new SubModel());
        return "subs";
    }

    @PostMapping("/subs")
    public String addSub(@Valid @ModelAttribute SubModel sub, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<SubModel> subs = subService.findAllSub();
            model.addAttribute("subs", subs);
            model.addAttribute("sub", sub);
            return "subs";
        }
        subService.createSub(sub);
        return "redirect:/subs";
    }

    @GetMapping("/subs/edit/{id}")
    public String editSub(@PathVariable Long id, Model model) {
        SubModel sub = subService.findSubById(id);
        model.addAttribute("sub", sub);
        return "editSub";
    }

    @PostMapping("/subs/update")
    public String updateSub(@Valid @ModelAttribute SubModel sub, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<SubModel> subs = subService.findAllSub();
            model.addAttribute("subs", subs);
            model.addAttribute("subs", sub);
            return "subs";
        }
        subService.updateSub(sub);
        return "redirect:/subs";
    }

    @GetMapping("/subs/delete/{id}")
    public String deleteSub(@PathVariable Long id) {
        subService.deleteSub(id);
        return "redirect:/subs";
    }
}
