package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.dtos.EmployeeDto;
import kodlamaio.HRMS.entities.dtos.EmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    Employer findByEmail(String email);

    @Query("Select new  kodlamaio.HRMS.entities.dtos.EmployerDto"
            + "(e.companyName,e.email, e.webAddress, e.phoneNumber, i.url) "
            + "From Employer e Inner Join e.images i")
    List<EmployerDto> getDto();


}
