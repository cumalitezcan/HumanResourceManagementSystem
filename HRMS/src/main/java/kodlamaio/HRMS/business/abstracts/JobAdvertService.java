package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    Result add (JobAdvert jobAdvert);
    DataResult<List<JobAdvert>> getAll();
    DataResult<List<JobAdvert>> getAllSorted();
    DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize);
    DataResult<JobAdvert> getByJobAdvertName(String jobAdvertName);
    DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(String jobAdvertName, int jobPositionId);
    DataResult<List<JobAdvert>> getByJobAdvertNameAndEmployer(String jobAdvertName, int employerId);
    DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId);
    DataResult<List<JobAdvert>> getByNameAndCity(String jobAdvertName, int cityId);
}
