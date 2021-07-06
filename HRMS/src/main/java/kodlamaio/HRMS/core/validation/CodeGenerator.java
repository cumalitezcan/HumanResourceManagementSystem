package kodlamaio.HRMS.core.validation;


import java.util.UUID;


public class CodeGenerator {
    public static String sendVerificationCode(){
        UUID uuid = UUID.randomUUID();
        String code= uuid.toString().split("-")[0];
        return code;
    }
}
