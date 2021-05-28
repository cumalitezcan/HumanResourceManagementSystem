package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    DataResult<List<JobPosition>> getAll();

}
