package kodlamaio.HRMS.core.validation;

import org.springframework.stereotype.Service;

@Service
public class MailVerification {
    public void sendMail(String emailAddress, String code) {
        System.out.println("E-mail sent to " + emailAddress + "");
    }
}