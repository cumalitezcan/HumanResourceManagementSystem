package kodlamaio.HRMS.core.adapter;

import kodlamaio.HRMS.core.mernis.FIIKPSPublicSoap;
import kodlamaio.HRMS.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CheckMernisService {
    @Override
    public boolean checkIfRealTcNo(Candidate candidate) {

        FIIKPSPublicSoap client = new FIIKPSPublicSoap();

        boolean serviceResult=false;

        try {

            serviceResult = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity()),
                    candidate.getFirstName().toUpperCase(),
                    candidate.getLastName().toUpperCase(),
                    candidate.getBirthYear());



        } catch (Exception e) {

            System.out.println("Not a valid person");

        }

        return serviceResult;
    }
}
