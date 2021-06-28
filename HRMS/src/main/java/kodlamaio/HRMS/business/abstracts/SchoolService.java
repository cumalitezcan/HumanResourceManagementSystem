package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result add(School school);
    DataResult<List<School>> getAll();
    DataResult<School> getById(int id);
    DataResult<List<School>> getByCandidateId(int candidateId);
}
