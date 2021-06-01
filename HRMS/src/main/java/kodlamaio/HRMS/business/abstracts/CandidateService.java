package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {

     DataResult<List<Candidate>> getAll();
     Result add(Candidate candidate);
}
