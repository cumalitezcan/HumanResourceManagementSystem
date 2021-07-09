package kodlamaio.HRMS.api.controllers;


import kodlamaio.HRMS.business.abstracts.SchoolService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @GetMapping("/getAll")
    public DataResult<List<School>> getAll(){
        return this.schoolService.getAll();
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<School>> getByCandidateId(@RequestParam int candidateId){
        return this.schoolService.getByCandidateId(candidateId);
    }
}
