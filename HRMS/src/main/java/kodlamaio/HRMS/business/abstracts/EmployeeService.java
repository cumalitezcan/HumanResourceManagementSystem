package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employee;
import kodlamaio.HRMS.entities.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Result add(Employee employee);
    DataResult<Employee> getById(int id);
    DataResult<List<Employee>> getAll();
    DataResult<List<EmployeeDto>> getDto();
}
