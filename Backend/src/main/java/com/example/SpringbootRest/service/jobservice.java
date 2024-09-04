package com.example.SpringbootRest.service;

import com.example.SpringbootRest.model.JobPosts;
import com.example.SpringbootRest.repo.jobrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class jobservice {
    @Autowired
    private jobrepo repo;


    public void addJob(JobPosts jobPosts){                 // just send data to the repo layer
         repo.save(jobPosts);

    }

  public List<JobPosts> getAllJobs(){                    // just get the data from repo layer
        return repo.findAll();

  }

    public JobPosts getjob(int postId) {
        return repo.findById(postId).orElse(new JobPosts());
    }

    public void updatejob(JobPosts jobPost) {
         repo.save(jobPost);
    }

    public void deletejob(int postId) {
        repo.deleteById(postId);
    }


    public void load() {

    List<JobPosts> jobs = new ArrayList<>();

    // ****************************************************************************

    // constructor->injecting objects into ArrayList defined above.


        // Java Developer Job Post
        jobs.add(new JobPosts(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobs.add(
                new JobPosts(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobs.add(new JobPosts(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        // Network Engineer Job Post
        jobs.add(new JobPosts(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        // Mobile App Developer Job Post
        jobs
                .add(new JobPosts(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")));

        // DevOps Engineer Job Post
        jobs.add(
                new JobPosts(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));

        jobs
                .add(new JobPosts(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
                        2, List.of("User Experience", "User Interface Design", "Prototyping")));

        // Cybersecurity Analyst Job Post
        jobs
                .add(new JobPosts(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats",
                        4, List.of("Cybersecurity", "Network Security", "Incident Response")));


      repo.saveAll(jobs);
    }


    public List<JobPosts> search(String keyword) {

        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}

