package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Result add(Image image, MultipartFile imageFile);
    Result update(Image image);
    Result delete(int id);
    DataResult<Image> getByUserId(int userId);
    DataResult<List<Image>> getAll();
}
