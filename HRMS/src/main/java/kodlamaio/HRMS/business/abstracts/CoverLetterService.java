package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {
    Result add(CoverLetter coverLetter);
    DataResult<List<CoverLetter>> getAll();
    DataResult<CoverLetter> getById(int id);
    DataResult<CoverLetter> getByCandidateId(int candidateId);
}
