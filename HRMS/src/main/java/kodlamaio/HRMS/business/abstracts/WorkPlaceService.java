package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkPlace;

import java.util.List;

public interface WorkPlaceService {
    DataResult<List<WorkPlace>> getAll();
}
