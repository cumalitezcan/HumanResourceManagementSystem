package kodlamaio.HRMS.core.validation;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationManager implements VerificationService {

    @Override
    public boolean sendVerificationCode(String emailAddress) {
        UUID uuid = UUID.randomUUID();
        String code = uuid.toString();
        System.out.println(emailAddress+"Verification code sent to address.");
        System.out.println("Verification Code:"+ code);
        return true;
    }
}
