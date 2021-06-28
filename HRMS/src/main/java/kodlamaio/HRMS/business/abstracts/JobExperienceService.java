package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result add(JobExperience jobExperience);
    DataResult<List<JobExperience>> getAll();
    DataResult<JobExperience> getById(int id);
    DataResult<List<JobExperience>> getByCandidate_Id(int candidateId);
}
