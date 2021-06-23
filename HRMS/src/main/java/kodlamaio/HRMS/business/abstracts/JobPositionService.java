package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
    DataResult<JobPosition> getByTitle(String title);

}
