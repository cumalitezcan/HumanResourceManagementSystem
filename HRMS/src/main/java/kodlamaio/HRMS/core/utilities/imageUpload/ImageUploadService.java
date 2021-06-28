package kodlamaio.HRMS.core.utilities.imageUpload;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {

    @SuppressWarnings("rawtypes")
    DataResult<Map> uploadImageFile(MultipartFile imageFile);

}