package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    Candidate findByEmail(String email);
    Candidate findByNationalIdentity(String nationalIdentity);
    Candidate findById(int id);
    Candidate deleteById(int id);
}
