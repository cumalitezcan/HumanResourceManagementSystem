package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.*;
import kodlamaio.HRMS.core.business.BusinessRules;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.core.validation.CodeGenerator;
import kodlamaio.HRMS.core.validation.MailVerification;
import kodlamaio.HRMS.core.validation.VerificationService;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.VerificationByCode;
import kodlamaio.HRMS.entities.concretes.VerificationByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AuthManager implements AuthService {

    private EmployerService employerService;
    private CandidateService candidateService;
    private UserService userService;
    private VerificationByCodeService verificationByCodeService;
    private VerificationByEmployeeService verificationByEmployeeService;
    private MailVerification mailVerification ;

    @Autowired
    public AuthManager(EmployerService employerService, CandidateService candidateService,
                       VerificationByCodeService verificationByCodeService,VerificationByEmployeeService verificationByEmployeeService,
                       MailVerification mailVerification,UserService userService) {
        super();
        this.employerService = employerService;
        this.candidateService = candidateService;
        this.verificationByCodeService = verificationByCodeService;
        this.verificationByEmployeeService = verificationByEmployeeService;
        this.mailVerification = mailVerification;
    }

    @Override
    public Result registerEmployer(Employer employer, String confirmPassword) {
        var result =BusinessRules.run(this.confirmPassword(employer.getPassword(), confirmPassword),
                this.userExist(employer.getEmail()),this.checkEmailMatch(employer));
        if (result != null) {
            return result;
        }

        var addEmployer = this.employerService.add(employer);

        if(!addEmployer.isSuccess()) {

            return new ErrorResult("Employer not registered.");
        }

        var code = CodeGenerator.sendVerificationCode();
        VerificationByCode verifyCodeEntity = new VerificationByCode(employer.getId(), code);
        VerificationByEmployee verifyEmployeeEntity = new VerificationByEmployee(employer.getId(), null);
        this.verificationByCodeService.add(verifyCodeEntity);
        this.verificationByEmployeeService.add(verifyEmployeeEntity);
        this.mailVerification.sendMail(employer.getEmail(), code);
        return new SuccessResult();

    }

    @Override
    public Result registerCandidate(Candidate candidate, String confirmPassword) {
        var result = BusinessRules.run(this.confirmPassword(confirmPassword, confirmPassword),
                this.userExist(candidate.getEmail()));
        if (result != null) {
            return result;
        }

        var addCandidate = this.candidateService.add(candidate);

        if(!addCandidate.isSuccess()) {

            return new ErrorResult("Employer not registered.");
        }

        var code = CodeGenerator.sendVerificationCode();
        VerificationByCode verifyCodeEntity = new VerificationByCode(candidate.getId(), code);
        this.verificationByCodeService.add(verifyCodeEntity);
        this.mailVerification.sendMail(candidate.getEmail(), code);
        return new SuccessResult();

    }

    public Result confirmPassword(String password,String confirmPassword)
    {
        if (password.equals(confirmPassword)) {
            return new SuccessResult();
        }
        return new ErrorResult("Password does not match. Please re-enter your password.");
    }
    public Result checkEmailMatch(Employer employer) {
        var mailDomain = employer.getEmail().split("@")[1];
        return mailDomain.equals(employer.getWebAddress()) ? new SuccessResult() :
                new ErrorResult("E-mail domain and web address does not match.");
    }

    private Result userExist(String email) {
        if (this.userService.getByEmail(email).getData() == null)
        {
            return new SuccessResult();
        }
        return new ErrorResult();
    }




  /*  public boolean confirmPassword(String password,String confirmPassword)
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
    }*/
}
