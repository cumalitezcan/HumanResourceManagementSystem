package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="department")
    private String department;

    @Column(name="starting_date")
    private LocalDate startingDate;

    @Column(name="graduation_date")
    private LocalDate graduationDate;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
