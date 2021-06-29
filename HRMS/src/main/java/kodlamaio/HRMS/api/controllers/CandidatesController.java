package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid Candidate candidate){
        return ResponseEntity.ok(this.candidateService.add(candidate));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody int id){
        return this.candidateService.delete(id);
    }

    @GetMapping("/cv")
    public ResponseEntity<?> getCv(@RequestParam int candidateId){
        return ResponseEntity.ok(this.candidateService.getCandidateCv(candidateId));
    }
}
