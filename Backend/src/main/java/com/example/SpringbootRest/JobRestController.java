package com.example.SpringbootRest;

import com.example.SpringbootRest.model.JobPosts;
import com.example.SpringbootRest.service.jobservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private jobservice service;

@GetMapping("jobPosts")
    public List<JobPosts> getAllJobs(){
        return service.getAllJobs();           // here we returning the actual data that is list of jobs

    }
    @GetMapping("jobPosts/{postId}")
    public  JobPosts getjob(@PathVariable("postId") int postId){
    return service.getjob(postId);
    }
    @PostMapping("jobPosts")
    public void addJob(@RequestBody JobPosts jobPost){
    service.addJob(jobPost);
    }
    @PutMapping("jobPosts")
    public JobPosts updatejob(@RequestBody JobPosts jobPost){
    service.updatejob(jobPost);
     return service.getjob(jobPost.getPostId());
    }

    @DeleteMapping("jobPosts{postId}")
    public String deletejob(@RequestBody int postId){
    service.deletejob(postId);
    return "Deleted";

    }
    @GetMapping("load")
    public String loadData(){

    service.load();

    return "success";
    }
     @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPosts> searchByKeyword(@PathVariable("keyword") String keyword) {

    return service.search(keyword);

    }


}
