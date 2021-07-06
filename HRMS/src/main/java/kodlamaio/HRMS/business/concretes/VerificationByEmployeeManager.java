package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.VerificationByEmployeeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationByEmployeeDao;
import kodlamaio.HRMS.entities.concretes.VerificationByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationByEmployeeManager implements VerificationByEmployeeService {

    public VerificationByEmployeeDao verificationByEmployeeDao;
    @Autowired
    public VerificationByEmployeeManager(VerificationByEmployeeDao verificationByEmployeeDao) {
        super();
        this.verificationByEmployeeDao = verificationByEmployeeDao;
    }

    @Override
    public Result add(VerificationByEmployee verificationByEmployee) {
        this.verificationByEmployeeDao.save(verificationByEmployee);
        return new SuccessResult();
    }

    @Override
    public Result update(VerificationByEmployee verificationByEmployee, int employeeId) {
        this.verificationByEmployeeDao.save(verificationByEmployee);
        return new SuccessResult();
    }

    @Override
    public Result delete(VerificationByEmployee verificationByEmployee) {
        this.verificationByEmployeeDao.delete(verificationByEmployee);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<VerificationByEmployee>> getAll() {
        return new SuccessDataResult<List<VerificationByEmployee>>(this.verificationByEmployeeDao.findAll());
    }

    @Override
    public DataResult<VerificationByEmployee> getById(int id) {
        return new SuccessDataResult<VerificationByEmployee>(this.verificationByEmployeeDao.getById(id));
    }

    @Override
    public DataResult<VerificationByEmployee> getByEmployerId(int employerId) {
        return new  SuccessDataResult<VerificationByEmployee>(this.verificationByEmployeeDao.getByEmployerId(employerId));
    }


}
