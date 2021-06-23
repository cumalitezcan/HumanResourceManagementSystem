package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.JobAdvertService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        super();
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll() {
        return this.jobAdvertService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert product) {
        return this.jobAdvertService.add(product);
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
    public DataResult<JobAdvert> getByProductName(@RequestParam String productName){
        return this.jobAdvertService.getByJobAdvertName(productName);
    }

}
