package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.HRMS.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao){
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public Result add(JobExperience jobExperience) {
       this.jobExperienceDao.save(jobExperience);
       return new SuccessResult("Job Experience added");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
    }

    @Override
    public DataResult<JobExperience> getById(int id) {
        return new SuccessDataResult<JobExperience>(this.jobExperienceDao.getById(id));
    }

    @Override
    public DataResult<List<JobExperience>> getByCandidate_Id(int candidateId) {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByCandidate_Id(candidateId));    }
}
