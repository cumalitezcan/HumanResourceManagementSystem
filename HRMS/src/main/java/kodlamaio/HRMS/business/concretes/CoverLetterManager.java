package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CoverLetterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.HRMS.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverLetterManager implements CoverLetterService {


    CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao){
        this.coverLetterDao = coverLetterDao;
    }


    @Override
    public Result add(CoverLetter coverLetter) {
        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("Cover Letter add");
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
    }

    @Override
    public DataResult<CoverLetter> getById(int id) {
        return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getById(id));
    }
}
