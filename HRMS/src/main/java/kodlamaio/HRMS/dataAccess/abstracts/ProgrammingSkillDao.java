package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.ProgrammingSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingSkillDao extends JpaRepository<ProgrammingSkill,Integer> {
 ProgrammingSkill getById(int id);
}
