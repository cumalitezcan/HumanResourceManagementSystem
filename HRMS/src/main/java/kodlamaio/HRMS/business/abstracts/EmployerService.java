package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.dtos.EmployerDto;

import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    DataResult<Employer> getByEmail(String email);
    DataResult<List<EmployerDto>> getDto();

}
