package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}
