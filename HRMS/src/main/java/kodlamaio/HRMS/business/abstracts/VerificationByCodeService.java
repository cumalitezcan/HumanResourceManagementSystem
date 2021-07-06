package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationByCode;

import java.util.List;

public interface VerificationByCodeService {
    Result add(VerificationByCode verificationByCode);
    Result update(VerificationByCode verificationByCode);
    Result delete(VerificationByCode verificationByCode);
    DataResult<List<VerificationByCode>> getAll();
    DataResult<VerificationByCode> getById(int id);
    DataResult<VerificationByCode> getByUserId(int userId);
}
