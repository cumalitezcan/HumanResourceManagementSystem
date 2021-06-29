package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return this.languageService.add(language);
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<Language>> getByCandidateId(int candidateId){
        return this.languageService.getByCandidate_Id(candidateId);
    }

}
