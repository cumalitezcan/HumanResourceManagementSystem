package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
    JobExperience getById(int id);
    List<JobExperience> getByCandidate_Id(int candidateId);
}
