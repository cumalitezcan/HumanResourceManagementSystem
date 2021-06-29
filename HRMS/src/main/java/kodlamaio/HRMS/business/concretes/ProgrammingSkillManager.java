package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.ProgrammingSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ProgrammingSkillDao;
import kodlamaio.HRMS.entities.concretes.ProgrammingSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingSkillManager implements ProgrammingSkillService {
    private ProgrammingSkillDao programmingSkillDao;

    @Autowired
    public ProgrammingSkillManager(ProgrammingSkillDao programmingSkillDao) {
        super();
        this.programmingSkillDao = programmingSkillDao;
    }

    @Override
    public Result add(ProgrammingSkill programmingSkill) {
        this.programmingSkillDao.save(programmingSkill);
        return new SuccessResult("Programming skills added");
    }

    @Override
    public DataResult<List<ProgrammingSkill>> getAll() {
        return new SuccessDataResult<List<ProgrammingSkill>>(this.programmingSkillDao.findAll());
    }

    @Override
    public DataResult<ProgrammingSkill> getById(int id) {
        return new SuccessDataResult<ProgrammingSkill>(this.programmingSkillDao.getById(id));
    }

    @Override
    public DataResult<List<ProgrammingSkill>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<ProgrammingSkill>>(this.programmingSkillDao.getByCandidate_Id(candidateId));
    }

}
