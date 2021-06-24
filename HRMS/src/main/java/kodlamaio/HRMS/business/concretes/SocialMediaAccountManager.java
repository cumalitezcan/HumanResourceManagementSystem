package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.SocialMediaAccountService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SocialMediaAccountDao;
import kodlamaio.HRMS.entities.concretes.SocialMediaAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService {
    private SocialMediaAccountDao socialMediaAccountDao;
    @Autowired
    public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccountDao) {
        super();
        this.socialMediaAccountDao = socialMediaAccountDao;
    }


    @Override
    public Result add(SocialMediaAccount socialMediaAccount) {
        this.socialMediaAccountDao.save(socialMediaAccount);
        return new SuccessResult("Social media account added.");
    }

    @Override
    public DataResult<List<SocialMediaAccount>> getAll() {
        return new SuccessDataResult<List<SocialMediaAccount>>(this.socialMediaAccountDao.findAll());
    }


}
