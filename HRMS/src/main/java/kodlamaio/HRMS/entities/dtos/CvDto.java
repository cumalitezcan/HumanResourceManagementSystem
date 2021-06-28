package kodlamaio.HRMS.entities.dtos;

import kodlamaio.HRMS.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

    private User user;
    //private Image image;
    private CoverLetter coverLetter;
    private List<School> schools;
    private List<ProgrammingSkill>	programmingSkills;
    private List<Language> languages;
    private List<JobExperience> experiences;
    private List<SocialMediaAccount> socialMediaAccounts;
}
