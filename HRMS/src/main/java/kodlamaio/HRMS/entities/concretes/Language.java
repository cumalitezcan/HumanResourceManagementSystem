package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "language")
    private String language;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "level")
    private int level;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}