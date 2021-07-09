package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.VerificationByEmployeeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verificationsByEmployee")
@CrossOrigin
public class VerificationsByEmployeeController {

    private VerificationByEmployeeService verificationByEmployeeService;

    @Autowired
    public VerificationsByEmployeeController(VerificationByEmployeeService verificationByEmployeeService) {
        super();
        this.verificationByEmployeeService = verificationByEmployeeService;
    }

    @PostMapping("/update")
    public Result update(@RequestBody VerificationByEmployee verificationByEmployee, int employeeId) {
        return this.verificationByEmployeeService.update(verificationByEmployee, employeeId);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody VerificationByEmployee verificationByEmployee) {
        return this.verificationByEmployeeService.delete(verificationByEmployee);
    }

    @GetMapping("/getAll")
    public DataResult<List<VerificationByEmployee>> getAll() {
        return verificationByEmployeeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<VerificationByEmployee> getById(@RequestBody int id) {
        return verificationByEmployeeService.getById(id);
    }
}
