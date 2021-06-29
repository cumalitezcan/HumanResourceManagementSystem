package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.ProgrammingSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ProgrammingSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programmingSkills")
public class ProgrammingSkillsController {
    private ProgrammingSkillService programmingSkillService;

    @Autowired
    public ProgrammingSkillsController(ProgrammingSkillService programmingSkillService) {
        super();
        this.programmingSkillService = programmingSkillService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProgrammingSkill programmingSkill) {
        return this.programmingSkillService.add(programmingSkill);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<ProgrammingSkill>> getByCandidateId(int candidateId) {
        return this.programmingSkillService.getByCandidateId(candidateId);
    }
}


