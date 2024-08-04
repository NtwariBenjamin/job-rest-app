package com.benjamin.springbootrest.repo;


import com.benjamin.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    @Query("select j from JobPost j where j.postProfile=?1")
    JobPost getJobProfile(String postProfile);

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}

//    List<JobPost> jobs=new ArrayList<>(Arrays.asList(
//            new JobPost(1,"Java Developer","Experienced in java and Spring boot",2,List.of("DevOps","java","Springboot")),
//            new JobPost(2,"Full Stack Developer","Experienced in java and Spring boot and Cloud Computing",3,List.of("DevOps","java","Cloud Computing")),
//            new JobPost(3,"Frontend Developer","Experienced in HTML,CSS,Js and Bootstrap",1,List.of("CSS","HTML","JQUERY")),
//            new JobPost(4, "Cyber security Analyst", "Protect computer systems and networks from cyber threats",
//                    4, List.of("Cyber security", "Network Security", "Incident Response"))
//    ));
//    public List<JobPost> getAllJobs(){
//        return jobs;
//    }
//    public void  addJob(JobPost job){
//        jobs.add(job);
//        System.out.println(jobs);
//    }
//
//    public JobPost getJob(int postId) {
//        for(JobPost job: jobs){
//            if (job.getPostId()==postId){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public JobPost getJobProfile(String postProfile) {
//        for (JobPost jobPost:jobs){
//            if (jobPost.getPostProfile().equals(postProfile) ){
//                return jobPost;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for(JobPost jobPost1: jobs){
//            if (jobPost1.getPostId()== jobPost.getPostId()){
//                jobPost1.setPostProfile(jobPost.getPostProfile());
//                jobPost1.setPostDesc(jobPost.getPostDesc());
//                jobPost1.setReqExperience(jobPost.getReqExperience());
//                jobPost1.setPostTechStack(jobPost.getPostTechStack());
//
//            }
//        }
//    }
//
//    public void deleteJob(int postId) {
//        for (JobPost jobPost:jobs){
//            if (jobPost.getPostId()==postId){
//                jobs.remove(jobPost);
//            }
//        }
//    }
