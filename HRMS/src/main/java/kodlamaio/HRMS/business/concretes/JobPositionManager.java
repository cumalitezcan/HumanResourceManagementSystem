package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HRMS.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

   @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>
                (this.jobPositionDao.findAll(),"Job List");

    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);

        return new SuccessDataResult("Job added");
    }


}
