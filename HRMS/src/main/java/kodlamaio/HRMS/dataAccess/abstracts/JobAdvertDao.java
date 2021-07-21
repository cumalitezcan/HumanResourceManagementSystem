package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.JobAdvert;
import kodlamaio.HRMS.entities.dtos.JobAdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {
    JobAdvert getByJobAdvertName(String jobAdvertName);
    JobAdvert getById(int id);
    JobAdvert getByJobAdvertNameAndJobPosition_Id(String jobAdvertName, int jobPositionId);
    List<JobAdvert> getByJobAdvertNameAndEmployer_Id(String jobAdvertName, int employerId);
    List<JobAdvert> getByJobAdvertNameAndCityId(String jobAdvertName, int cityId);

    @Query("From JobAdvert where jobAdvertName=:jobAdvertName and city.id=:cityId")
    List<JobAdvert> getByNameAndCity(String jobAdvertName, int cityId);

    @Query("From JobAdvert where isOpen = true") //aktif iş ilanlarını listeler
    List<JobAdvert> getAllActiveJobAdverts();

    @Query("From JobAdvert where isOpen = true Order By publishedDate asc ") //tarihe göre listeler
    List<JobAdvert> getAllByCreationDateAsc();


    @Query("From JobAdvert where isOpen = true and employer.companyName=:companyName") //şirket ismine göre listeler
    List<JobAdvert> getAllActiveJobAdvertByEmployer_CompanyName(String companyName);

    @Query("Select new  kodlamaio.HRMS.entities.dtos.JobAdvertDto"
            + "(j.jobPosition.id,j.employer.id,j.city.id,j.workPlace.id,j.workTime.id," +
            "j.salaryMax,j.salaryMin,j.openPositionCount,j.description,j.applicationDeadline,j.isOpen) "
            + "From JobAdvert j")
    List<JobAdvertDto> getDto();
}
