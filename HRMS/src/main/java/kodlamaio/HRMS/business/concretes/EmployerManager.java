package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

   private EmployerDao employerDao;

    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
       return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer List");
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessDataResult("Employer Added");
    }
}
