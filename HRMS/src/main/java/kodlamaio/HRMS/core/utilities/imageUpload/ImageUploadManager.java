package kodlamaio.HRMS.core.utilities.imageUpload;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ImageUploadManager implements ImageUploadService {

    private Cloudinary cloudinary;

    public ImageUploadManager(){

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name","doxii8nvp",
                "api_key", "567729743392646",
                "api_secret", "0Qke-3TX7KkFi8ceUDEZr1zsuXg"
        ));
    }

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        try {

            @SuppressWarnings("unchecked")
            Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<>(resultMap);

        }
        catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<>();
    }

}
