package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.JobExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        super();
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("/add")
    public Result add (@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<JobExperience>> getByCandidateId(@RequestParam int candidateId){
        return this.jobExperienceService.getByCandidate_Id(candidateId);
    }
}
