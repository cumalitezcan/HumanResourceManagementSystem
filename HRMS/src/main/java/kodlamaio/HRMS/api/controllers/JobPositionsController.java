package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }
}
