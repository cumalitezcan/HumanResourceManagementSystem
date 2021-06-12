package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="job_titles")
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvert> jobAdverts;
}
