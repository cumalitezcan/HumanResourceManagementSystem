package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.JobAdvertService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        super();
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvert>> getAll() {
        return this.jobAdvertService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.add(jobAdvert);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvert jobAdvert) {
        return jobAdvertService.update(jobAdvert);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {
        return this.jobAdvertService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<JobAdvert>> getAllSorted() {
        return this.jobAdvertService.getAllSorted();
    }

    @GetMapping("/getByNameJobAdvert")
    public DataResult<JobAdvert> getByJobAdvertName(@RequestParam String jobAdvertName){
        return this.jobAdvertService.getByJobAdvertName(jobAdvertName);
    }

    @GetMapping("/getAllActiveJobAdverts")
    public DataResult<List<JobAdvert>> getAllActiveJobAdverts() {
        return this.jobAdvertService.getAllActiveJobAdverts();
    }

    @GetMapping("/getAllByCreationDateAsc")
    public DataResult<List<JobAdvert>> getAllByCreationDateAsc(){
        return jobAdvertService.getAllByCreationDateAsc();
    }

    @GetMapping("/getByIsActiveTrueAndEmployer_CompanyName")
    public DataResult<List<JobAdvert>> getByIsActiveTrueAndEmployer_CompanyName( String companyName){
        return this.jobAdvertService.getAllActiveJobAdvertByCompanyName(companyName);
    }

    @PostMapping("/closeJobAdvert")
    public Result closeJobAdvert(@RequestParam("id") int id) {
        return jobAdvertService.closeJobAdvert(id);
    }

    @PostMapping("/openJobAdvert")
    public Result openJobAdvert(@RequestParam("id") int id) {
        return jobAdvertService.openJobAdvert(id);
    }

}
