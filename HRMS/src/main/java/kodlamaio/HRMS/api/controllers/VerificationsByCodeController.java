package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.VerificationByCodeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationByCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/verificationsByCode")
public class VerificationsByCodeController {
    private VerificationByCodeService verificationByCodeService;

    @Autowired
    public VerificationsByCodeController(VerificationByCodeService verificationByCodeService) {
        super();
        this.verificationByCodeService = verificationByCodeService;
    }

    @PostMapping("/update")
    public Result update(@RequestBody VerificationByCode verificationByCode) {
        return this.verificationByCodeService.update(verificationByCode);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody VerificationByCode verificationByCode) {
        return this.verificationByCodeService.delete(verificationByCode);
    }

    @GetMapping("/getAll")
    public DataResult<List<VerificationByCode>> getAll() {
        return this.verificationByCodeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<VerificationByCode> getById(@RequestParam int id) {
        return this.verificationByCodeService.getById(id);
    }

}
