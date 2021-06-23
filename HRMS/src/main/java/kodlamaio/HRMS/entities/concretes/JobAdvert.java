package kodlamaio.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;



    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "job_advert_name")
    private String jobAdvertName;

    @Column(name = "salary_max")
    private int salaryMax;

    @Column(name = "salary_min")
    private int salaryMin;

    @Column(name = "description")
    private String description;

    @Column(name = "open_position_count")
    private int openPositionCount;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column (name = "is_open",columnDefinition="boolean default true")
    private boolean isOpen;


}
