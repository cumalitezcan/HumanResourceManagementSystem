package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.*;
import kodlamaio.HRMS.core.adapter.CheckMernisService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.dtos.CandidateDto;
import kodlamaio.HRMS.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CandidateManager implements CandidateService {


    private CheckMernisService checkMernisService;
    private CandidateDao candidateDao;
    private ImageService imageService;
    private CoverLetterService coverLetterService;
    private JobExperienceService jobExperienceService;
    private SchoolService schoolService;
    private LanguageService languageService;
    private ProgrammingSkillService programmingSkillService;
    private SocialMediaAccountService socialMediaAccountService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao,CheckMernisService checkMernisService,
                            CoverLetterService coverLetterService, JobExperienceService jobExperienceService, SchoolService schoolService,
                            LanguageService languageService, ProgrammingSkillService programmingSkillService,
                            SocialMediaAccountService socialMediaAccountService) {
       super();
        this.candidateDao = candidateDao;
        this.checkMernisService = checkMernisService;
        this.imageService = imageService;
        this.coverLetterService = coverLetterService;
        this.jobExperienceService = jobExperienceService;
        this.schoolService = schoolService;
        this.languageService = languageService;
        this.programmingSkillService = programmingSkillService;
        this.socialMediaAccountService = socialMediaAccountService;
    }

    //Tüm alanlar zorunlu mu?
    private boolean validationForCandidate(Candidate candidate){
        if (Objects.isNull(candidate.getNationalIdentity()) || Objects.isNull(candidate.getFirstName())
                || Objects.isNull(candidate.getLastName()) || Objects.isNull(candidate.getEmail())
                || Objects.isNull(candidate.getPassword()) || Objects.isNull(candidate.getBirthYear())) {

            return false;
        }
        return true;
    }

    //Eposta kontrolü
    private boolean checkIfEmailExists(String email){
        if(this.candidateDao.findByEmail(email) != null){
            return false;
        }
        return true;
    }


    private boolean checkIfNationalIdentityExists(String nationalIdentity){
        if(this.candidateDao.findByNationalIdentity(nationalIdentity) != null){
            return false;
        }
        return true;
    }



    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Candidate List");

    }

    @Override
    public Result add(Candidate candidate) {
        if(!checkMernisService.checkIfRealTcNo(candidate)){
            return new ErrorResult("Not a valid person");
        }
    else if(!validationForCandidate(candidate)){
         return new ErrorResult("You have entered incomplete information. Please check your information again.");
     }
     if(!checkIfEmailExists(candidate.getEmail())){
         return new ErrorResult("This email address already exists");
     }
     if(!checkIfNationalIdentityExists(candidate.getNationalIdentity())){
            return new ErrorResult("This national identity already exists");
     }

     this.candidateDao.save(candidate);
     return new SuccessResult("Candidate added");
    }

    @Override
    public DataResult<Candidate> getByEmail(String email) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
    }

    @Override
    public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalIdentity(nationalIdentity));
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findById(id));
    }

    @Override
    public Result delete(int id) {
        this.candidateDao.deleteById(id);
        return new SuccessResult("Candidate deleted");
    }

    @Override
    public DataResult<CvDto> getCandidateCv(int candidateId) {
        CvDto cv = new CvDto();
        cv.setUser(this.getById(candidateId).getData());
        cv.setImage(this.imageService.getByUserId(candidateId).getData());
        cv.setCoverLetter(this.coverLetterService.getByCandidateId(candidateId).getData());
        cv.setSchools(this.schoolService.getByCandidateId(candidateId).getData());
        cv.setLanguages(this.languageService.getByCandidate_Id(candidateId).getData());
        cv.setProgrammingSkills(this.programmingSkillService.getByCandidateId(candidateId).getData());
        cv.setExperiences(this.jobExperienceService.getByCandidate_Id(candidateId).getData());
        cv.setSocialMediaAccounts(this.socialMediaAccountService.getByCandidate_Id(candidateId).getData());
        return new SuccessDataResult<CvDto>(cv);
    }

    @Override
    public DataResult<List<CandidateDto>> getDto() {
        return new SuccessDataResult<List<CandidateDto>>(this.candidateDao.getDto());
    }



}
