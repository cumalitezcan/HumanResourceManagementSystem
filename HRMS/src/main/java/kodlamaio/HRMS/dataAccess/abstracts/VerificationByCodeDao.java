package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.VerificationByCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationByCodeDao extends JpaRepository<VerificationByCode,Integer> {
    VerificationByCode getByUserId(int userId);
    VerificationByCode getById(int id);
}
