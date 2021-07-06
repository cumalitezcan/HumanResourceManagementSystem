package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.VerificationByCodeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationByCodeDao;
import kodlamaio.HRMS.entities.concretes.VerificationByCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationByCodeManager implements VerificationByCodeService {

    private VerificationByCodeDao verificationByCodeDao;
    @Autowired
    public VerificationByCodeManager(VerificationByCodeDao verificationByCodeDao) {
        super();
        this.verificationByCodeDao = verificationByCodeDao;
    }

    @Override
    public Result add(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.save(verificationByCode);
        return new SuccessResult();
    }

    @Override
    public Result update(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.save(verificationByCode);
        return new SuccessResult();
    }

    @Override
    public Result delete(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.delete(verificationByCode);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<VerificationByCode>> getAll() {
        return new SuccessDataResult<List<VerificationByCode>>(this.verificationByCodeDao.findAll());
    }

    @Override
    public DataResult<VerificationByCode> getById(int id) {
        return new SuccessDataResult<VerificationByCode>(this.verificationByCodeDao.getById(id));
    }

    @Override
    public DataResult<VerificationByCode> getByUserId(int userId) {
        return null;
    }

}
