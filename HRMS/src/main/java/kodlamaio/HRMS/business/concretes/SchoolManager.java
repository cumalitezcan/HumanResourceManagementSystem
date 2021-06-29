package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.SchoolService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SchoolDao;
import kodlamaio.HRMS.entities.concretes.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("New school added.");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
    }

    @Override
    public DataResult<School> getById(int id) {
        return new SuccessDataResult<School>(this.schoolDao.getById(id));
    }

    @Override
    public DataResult<List<School>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getByCandidateId(candidateId));    }

}
