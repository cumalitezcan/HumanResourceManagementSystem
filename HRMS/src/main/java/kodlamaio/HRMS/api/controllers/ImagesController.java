package kodlamaio.HRMS.api.controllers;

import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Image;
import kodlamaio.HRMS.entities.concretes.JobPosition;
import kodlamaio.HRMS.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private ImageService imageService;
    private UserService userService;

    @Autowired
    public ImagesController(ImageService imageService, UserService userService) {
        super();
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
        User user = this.userService.getById(id).getData();
        Image image = new Image();
        image.setUser(user);
        return this.imageService.add(image, imageFile);

    }

    @GetMapping("/getall")
    public DataResult<List<Image>> getAll(){
        return this.imageService.getAll();
    }


}
