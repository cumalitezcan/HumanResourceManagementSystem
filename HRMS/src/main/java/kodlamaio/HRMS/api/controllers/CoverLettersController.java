package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.CoverLetterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/coverLetters")
public class CoverLettersController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        super();
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CoverLetter coverLetter) {
        return this.coverLetterService.add(coverLetter);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<CoverLetter> getByCandidateId(@RequestParam int candidateId) {
        return this.coverLetterService.getByCandidateId(candidateId);
    }
}
