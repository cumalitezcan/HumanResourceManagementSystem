package kodlamaio.HRMS.api.controllers;


import kodlamaio.HRMS.business.abstracts.WorkPlaceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkPlace;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/workplaces")
public class WorkPlacesController {

    private WorkPlaceService workPlaceService;

    public WorkPlacesController(WorkPlaceService workPlaceService) {
        super();
        this.workPlaceService = workPlaceService;
    }

    @GetMapping("/getAll")
   public DataResult<List<WorkPlace>> getAll(){
        return this.workPlaceService.getAll();
    }
}
