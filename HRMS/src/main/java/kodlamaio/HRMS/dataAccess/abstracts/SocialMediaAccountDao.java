package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaAccountDao extends JpaRepository<SocialMediaAccount,Integer> {
    List<SocialMediaAccount> getByCandidate_Id(int candidateId);
    SocialMediaAccount getById(int id);
}
