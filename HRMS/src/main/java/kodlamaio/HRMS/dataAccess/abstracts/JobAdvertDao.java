package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {
    JobAdvert getByJobAdvertName(String jobAdvertName);
    JobAdvert getByJobAdvertNameAndJobPosition_Id(String jobAdvertName, int jobPositionId);
    List<JobAdvert> getByJobAdvertNameAndEmployer_Id(String jobAdvertName, int employerId);
    List<JobAdvert> getByJobAdvertNameAndCityId(String jobAdvertName, int cityId);

    @Query("From JobAdvert where jobAdvertName=:jobAdvertName and city.id=:cityId")
    List<JobAdvert> getByNameAndCity(String jobAdvertName, int cityId);


}
