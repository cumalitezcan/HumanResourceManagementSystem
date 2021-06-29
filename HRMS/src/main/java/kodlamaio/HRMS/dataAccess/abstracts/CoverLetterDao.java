package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer> {
    CoverLetter getById(int id);
    CoverLetter getByCandidate_Id(int candidate_id);
}
