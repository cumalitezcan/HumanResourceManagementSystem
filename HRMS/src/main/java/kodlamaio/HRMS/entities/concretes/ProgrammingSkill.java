package kodlamaio.HRMS.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="programming_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "programming_name")
    private String programmingName;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
