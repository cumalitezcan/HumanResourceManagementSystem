package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.VerificationByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationByEmployeeDao extends JpaRepository<VerificationByEmployee,Integer> {
    VerificationByEmployee getByEmployerId(int employerId);
    VerificationByEmployee getById(int id);
}
