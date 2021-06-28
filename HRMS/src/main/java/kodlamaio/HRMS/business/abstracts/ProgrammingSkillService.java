package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ProgrammingSkill;

import java.util.List;

public interface ProgrammingSkillService {
    Result add(ProgrammingSkill programmingSkill);
    DataResult<List<ProgrammingSkill>> getAll();
    DataResult<ProgrammingSkill> getById(int id);
    DataResult<List<ProgrammingSkill>> getByCandidateId(int candidateId);


}
