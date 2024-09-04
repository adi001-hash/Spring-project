package com.example.SpringbootRest.repo;

import com.example.SpringbootRest.model.JobPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public interface jobrepo extends JpaRepository<JobPosts,Integer> {

    public List<JobPosts> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);




 /*public List<JobPosts> getAllJobs() {      // return all jobs present in repo class
        return jobs;
    }

    public void addJob(JobPosts job) {      // add job to the list
        jobs.add(job);
    }

    public JobPosts getjob(int postId) {

        for (JobPosts job : jobs) {
            if (job.getPostId() == postId)
                return job;
        }
        return null;

    }

    public void updatejob(JobPosts jobPost) {
        for (JobPosts jobpost1 : jobs) {
            if (jobpost1.getPostId() == jobPost.getPostId()) {
                jobpost1.setPostDesc(jobPost.getPostDesc());
                jobpost1.setPostProfile(jobPost.getPostProfile());
                jobpost1.setReqExperience(jobPost.getReqExperience());
                jobpost1.setPostTechStack(jobPost.getPostTechStack());
            }

        }
    }*/

    /* public void deletejob(int postId) {

         for(JobPosts job : jobs){
             if(job.getPostId() == postId)
                 jobs.remove(job);
         }
     }*/
   /* public void deletejob(int postId) {
        Iterator<JobPosts> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            JobPosts job = iterator.next();
            if (job.getPostId() == postId) {
                iterator.remove();
                break;
            }
        }

    }*/
}