package kodlamaio.HRMS.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")

public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="workplace")
    private String workplace;

    @Column(name="starting_date")
    private LocalDate startingDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
