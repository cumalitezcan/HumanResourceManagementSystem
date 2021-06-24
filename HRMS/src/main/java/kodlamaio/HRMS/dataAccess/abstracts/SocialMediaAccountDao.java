package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaAccountDao extends JpaRepository<SocialMediaAccount,Integer> {

}
