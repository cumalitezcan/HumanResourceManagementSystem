package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Verification;

import java.util.List;

public interface VerificationService {
    Result add(Verification verification);
    Result update(Verification verification);
    Result delete(Verification verification);
    DataResult<List<Verification>> getAll();
    DataResult<Verification> getById(int id);
}
