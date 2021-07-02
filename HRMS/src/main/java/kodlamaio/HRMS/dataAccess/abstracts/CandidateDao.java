package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.dtos.CandidateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    Candidate findByEmail(String email);
    Candidate findByNationalIdentity(String nationalIdentity);
    Candidate findById(int id);
    Candidate deleteById(int id);

    @Query("Select new  kodlamaio.HRMS.entities.dtos.CandidateDto"
            + "(c.firstName, c.lastName, c.email, i.url) "
            + "From Candidate c Inner Join c.image i")
    List<CandidateDto> getDto();
}
