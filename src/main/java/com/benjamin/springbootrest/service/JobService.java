package com.benjamin.springbootrest.service;


import com.benjamin.springbootrest.model.JobPost;
import com.benjamin.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public JobPost getJobProfile(String postProfile) {
        return repo.getJobProfile(postProfile);
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs=new ArrayList<>(Arrays.asList(
                new JobPost(1,"Java Developer","Experienced in java and Spring boot",2,List.of("DevOps","java","Springboot")),
                new JobPost(2,"Full Stack Developer","Experienced in java and Spring boot and Cloud Computing",3,List.of("DevOps","java","Cloud Computing")),
                new JobPost(3,"Frontend Developer","Experienced in HTML,CSS,Js and Bootstrap",1,List.of("CSS","HTML","JQUERY")),
                new JobPost(4, "Cyber security Analyst", "Protect computer systems and networks from cyber threats",
                        4, List.of("Cyber security", "Network Security", "Incident Response"))
        ));
        repo.saveAll(jobs);

    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
