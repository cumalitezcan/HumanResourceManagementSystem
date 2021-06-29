package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ProgrammingSkill;
import kodlamaio.HRMS.entities.concretes.SocialMediaAccount;

import java.util.List;

public interface SocialMediaAccountService {
    Result add(SocialMediaAccount socialMediaAccount);
    DataResult<List<SocialMediaAccount>> getAll();
    DataResult<List<SocialMediaAccount>> getByCandidate_Id(int candidateId);


}
