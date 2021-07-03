package kodlamaio.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {



    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalIdentity;

    @Column(name="birth_year")
    private int birthYear;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CoverLetter> coverLetters;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<School> schools;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<ProgrammingSkill> programmingSkills;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<JobExperience> jobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<SocialMediaAccount> socialMediaAccounts;




}
