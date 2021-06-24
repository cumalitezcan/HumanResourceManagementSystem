package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.core.validation.VerificationService;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AuthManager implements AuthService {

    private EmployerService employerService;
    private CandidateService candidateService;
    private VerificationService verificationService;

    @Autowired
    public AuthManager(EmployerService employerService, CandidateService candidateService, VerificationService verificationService) {
        super();
        this.employerService = employerService;
        this.candidateService = candidateService;
        this.verificationService = verificationService;
    }

    public boolean confirmPassword(String password,String confirmPassword)
    {
        if (password.equals(confirmPassword)) {

            return true;
        }
        return false;
    }

    public static boolean isEmailValidation(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }



    //Şifre tekrarı
    @Override
    public Result registerEmployer(Employer employer, String confirmPassword) {
        if(!isEmailValidation(employer.getEmail())){
            return new ErrorResult("Invalid email address. Please enter your email address correctly.");

        }else if(!this.confirmPassword(employer.getPassword(),confirmPassword)){
            return new ErrorResult("Password does not match. Please re-enter your password");
        }
        var result = this.employerService.add(employer);

        if(result.isSuccess()){
            if(this.verificationService.sendVerificationCode(employer.getEmail())){
                return new SuccessResult("Employer Registered");
            }
        }

        return new ErrorResult();

    }

    @Override
    public Result registerCandidate(Candidate candidate, String confirmPassword) {
        if(!isEmailValidation(candidate.getEmail()))
        {
            return new ErrorResult("Invalid email address. Please enter your email address correctly.");
        }
        else if(!this.confirmPassword(candidate.getPassword(),confirmPassword)) {
            return new ErrorResult("Password does not match. Please re-enter your password.");
        }
        var result = this.candidateService.add(candidate);

        if(result.isSuccess()) {
            if(this.verificationService.sendVerificationCode(candidate.getEmail())) {
                return new SuccessResult("Candidate Registered.");
            }
        }

        return new ErrorResult();
    }
}
