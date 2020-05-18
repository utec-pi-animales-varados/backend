package business;

import constants.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class UploadImagenService {

    public Path createCouponPost(MultipartFile file) throws IOException {
        String extension = getExtension(file.getOriginalFilename());
        assert extension.length() > 0;
        Boolean png = extension.equals(".png"),
                jpg = extension.equals(".jpg"),
                jpeg = extension.equals(".jpeg");

        if (!png && !jpg && !jpeg) {
            return null;
        }
        String hash_name = getRandomCode(30) + extension;
        Path file_path = Paths.get(Constants.IMAGE_PATH, hash_name);
        Files.write(file_path, file.getBytes());
        return file_path;
    }

    public static String getRandomCode (int length) {
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (length-- > 0) {
            int character = (int)(Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String getExtension (String file_name) {
        String ext = "";
        int idx = file_name.lastIndexOf('.');
        if (idx != -1) {
            String tmp = file_name.substring(idx);
            if (tmp.matches("\\.[a-zA-Z0-9]+")) {
                ext = tmp;
            }
        }
        return ext.toLowerCase();
    }
}
