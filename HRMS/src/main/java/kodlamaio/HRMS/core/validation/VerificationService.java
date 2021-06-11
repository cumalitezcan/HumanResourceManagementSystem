package kodlamaio.HRMS.core.validation;

public interface VerificationService {

    boolean sendVerificationCode(String emailAddress);
}
