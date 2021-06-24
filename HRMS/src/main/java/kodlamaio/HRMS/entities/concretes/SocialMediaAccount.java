package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="social_media_accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
