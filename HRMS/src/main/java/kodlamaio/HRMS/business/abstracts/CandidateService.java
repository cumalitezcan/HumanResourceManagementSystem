package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.dtos.CvDto;

import java.util.List;

public interface CandidateService {

     DataResult<List<Candidate>> getAll();
     Result add(Candidate candidate);
     DataResult<Candidate> getByEmail(String email);
     DataResult<Candidate> getByNationalIdentity(String nationalIdentity);
     DataResult<Candidate> getById(int id);
     Result delete(int id);
     DataResult<CvDto> getCandidateCv(int candidateId);


}
