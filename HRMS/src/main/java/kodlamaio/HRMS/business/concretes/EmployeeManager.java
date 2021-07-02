package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.EmployeeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployeeDao;
import kodlamaio.HRMS.entities.concretes.Employee;
import kodlamaio.HRMS.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Result add(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("Employee added.");
    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
    }

    @Override
    public DataResult<List<EmployeeDto>> getDto() {
        return new SuccessDataResult<List<EmployeeDto>>(this.employeeDao.getDto());
    }

}
