package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobAdvertService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.HRMS.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        super();
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return  new SuccessResult("Job Advert added");
    }

    @Override
    public Result delete(JobAdvert jobAdvert) {
        this.jobAdvertDao.delete(jobAdvert);
        return new SuccessResult("Job Advert deleted");

    }

    @Override
    public Result update(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("Job Advert updated");
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"jobAdvertName");
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort));
    }

    @Override
    public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<JobAdvert> getByJobAdvertName(String jobAdvertName) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobAdvertName(jobAdvertName));
    }

    @Override
    public DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(String jobAdvertName, int jobPositionId) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobAdvertNameAndJobPosition_Id(jobAdvertName, jobPositionId));
    }

    @Override
    public DataResult<List<JobAdvert>> getByJobAdvertNameAndEmployer(String jobAdvertName, int employerId) {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByJobAdvertNameAndEmployer_Id(jobAdvertName, employerId));
    }

    @Override
    public DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId) {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByJobAdvertNameAndCityId(jobAdvertName, cityId));
    }

    @Override
    public DataResult<List<JobAdvert>> getByNameAndCity(String jobAdvertName, int cityId) {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByNameAndCity(jobAdvertName, cityId));
    }

    @Override
    public DataResult<List<JobAdvert>> getAllActiveJobAdverts() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveJobAdverts());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllByCreationDateAsc() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByCreationDateAsc());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvert>>(
                this.jobAdvertDao.getAllActiveJobAdvertByEmployer_CompanyName(companyName));
    }

    @Override
    public Result closeJobAdvert(int id) {
        JobAdvert jobAdvert = jobAdvertDao.getOne(id);

        if (jobAdvert == null) {
            return new ErrorResult("Job Advert is null");
        }

        if (jobAdvert.isOpen() == false) {
            return new ErrorResult("Job Advert is already close");
        }

        jobAdvert.setOpen(false);
        update(jobAdvert);
        return new SuccessResult("Job Advert has been closed");
    }

    @Override
    public Result openJobAdvert(int id) {
        JobAdvert jobAdvert = jobAdvertDao.getOne(id);

        if (jobAdvert == null) {
            return new ErrorResult("Job Advert is null");
        }

        if (jobAdvert.isOpen() == true) {
            return new ErrorResult("Job Advert is already open");
        }

        jobAdvert.setOpen(true);
        update(jobAdvert);
        return new SuccessResult("Job Advert has been opened");
    }


}
