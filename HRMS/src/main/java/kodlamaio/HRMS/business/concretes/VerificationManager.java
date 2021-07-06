package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.VerificationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationDao;
import kodlamaio.HRMS.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationManager implements VerificationService {

    private VerificationDao verificationDao;

    @Autowired
    public VerificationManager(VerificationDao verificationDao) {
        super();
        this.verificationDao = verificationDao;
    }


    @Override
    public Result add(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult();
    }

    @Override
    public Result update(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult();
    }

    @Override
    public Result delete(Verification verification) {
        this.verificationDao.delete(verification);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Verification>> getAll() {
        return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll());
    }

    @Override
    public DataResult<Verification> getById(int id) {
        return new SuccessDataResult<Verification>(this.verificationDao.getById(id));
    }
}
