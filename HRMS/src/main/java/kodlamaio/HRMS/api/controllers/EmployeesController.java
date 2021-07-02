package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.EmployeeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employee;
import kodlamaio.HRMS.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Employee employee){
        return this.employeeService.add(employee);
    }

    @GetMapping("/getById")
    public DataResult<Employee> getById(@RequestParam("id") int id){
        return this.employeeService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }

    @GetMapping("/getEmployerDto")
    public DataResult<List<EmployeeDto>> getDto() {
        return this.employeeService.getDto();
    }
}
