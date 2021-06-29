package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.ProgrammingSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingSkillDao extends JpaRepository<ProgrammingSkill,Integer> {
   ProgrammingSkill getById(int id);
   List<ProgrammingSkill> getByCandidate_Id(int candidateId);
}
