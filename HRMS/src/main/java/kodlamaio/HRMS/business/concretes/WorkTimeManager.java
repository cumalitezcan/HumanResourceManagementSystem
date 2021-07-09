package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.WorkTimeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.HRMS.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeManager implements WorkTimeService {
    private WorkTimeDao  workTimeDao ;

    @Autowired
    public WorkTimeManager(WorkTimeDao workTimeDao) {
        super();
        this.workTimeDao = workTimeDao;
    }

    @Override
    public DataResult<List<WorkTime>> getAll() {
        return new SuccessDataResult<>(this.workTimeDao.findAll());
    }

}
