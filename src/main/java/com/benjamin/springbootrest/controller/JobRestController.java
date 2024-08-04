package com.benjamin.springbootrest.controller;

import com.benjamin.springbootrest.model.JobPost;
import com.benjamin.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jndi.JndiAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {
    @Autowired
    private JobService service;
    @GetMapping("jobPosts")

    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPoster/{postProfile}")
    public JobPost getJobProfile(@PathVariable String postProfile){
        return service.getJobProfile(postProfile);
    }
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }
    @GetMapping("load")
    public String load(){
        service.load();
        return "Success";
    }
}
