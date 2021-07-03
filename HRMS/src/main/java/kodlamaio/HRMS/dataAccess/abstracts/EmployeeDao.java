package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.Employee;
import kodlamaio.HRMS.entities.dtos.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDao  extends JpaRepository<Employee, Integer> {

    Employee getById(int id);


    @Query("Select new  kodlamaio.HRMS.entities.dtos.EmployeeDto"
            + "(e.firstName, e.lastName,e.email, e.position, i.url) "
            + "From Employee e Inner Join e.images i")
    List<EmployeeDto> getDto();
}
