package kodlamaio.HRMS.api.controllers;


import kodlamaio.HRMS.business.abstracts.SocialMediaAccountService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.SocialMediaAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/socialMediaAccounts")
public class SocialMediaAccountsController {

    private SocialMediaAccountService socialMediaAccountService;

    @Autowired
    public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
        super();
        this.socialMediaAccountService = socialMediaAccountService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SocialMediaAccount socialMediaAccount) {
        return this.socialMediaAccountService.add(socialMediaAccount);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<SocialMediaAccount>> getByCandidateId(@RequestParam int candidateId){
        return this.socialMediaAccountService.getByCandidate_Id(candidateId);
    }


}
