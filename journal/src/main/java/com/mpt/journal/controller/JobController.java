package com.mpt.journal.controller;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class JobController {

    @Qualifier("jobServiceImpl")
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public String getAllJobs(Model model) {
        List<JobModel> jobs = jobService.findAllJob();
        model.addAttribute("jobs", jobs);
        model.addAttribute("job", new JobModel());
        return "jobs";
    }

    @PostMapping("/jobs")
    public String addJob(@Valid @ModelAttribute JobModel job, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<JobModel> jobs = jobService.findAllJob();
            model.addAttribute("jobs", jobs);
            model.addAttribute("job", job);
            return "jobs";
        }
        jobService.createJob(job);
        return "redirect:/jobs";
    }

    @GetMapping("/jobs/edit/{id}")
    public String editJob(@PathVariable Long id, Model model) {
        JobModel job = jobService.findJobById(id);
        model.addAttribute("job", job);
        return "editJob";
    }

    @PostMapping("/jobs/update")
    public String updateJob(@Valid @ModelAttribute JobModel job, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<JobModel> jobs = jobService.findAllJob();
            model.addAttribute("jobs", jobs);
            model.addAttribute("jobs", job);
            return "jobs";
        }
        jobService.updateJob(job);
        return "redirect:/jobs";
    }

    @GetMapping("/jobs/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }
}
