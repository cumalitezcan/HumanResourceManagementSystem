package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.dtos.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private CandidateService candidateService;



    @Autowired
    public CandidatesController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
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

    @GetMapping("/getCandidateDto")
    public DataResult<List<CandidateDto>> getDto(){
        return this.candidateService.getDto();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation errors");
        return errors;
    }
}
