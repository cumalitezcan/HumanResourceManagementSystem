package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationByEmployee;

import java.util.List;

public interface VerificationByEmployeeService {
    Result add(VerificationByEmployee verificationByEmployee);
    Result update(VerificationByEmployee verificationByEmployee, int employeeId);
    Result delete(VerificationByEmployee verificationByEmployee);
    DataResult<List<VerificationByEmployee>> getAll();
    DataResult<VerificationByEmployee> getById(int id);
    DataResult<VerificationByEmployee> getByEmployerId(int employerId);
}
