package controller;

import business.UploadImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@RestController
@RequestMapping("/uploadImagen")
public class UploadImagenController {
    final static String clientUrl = "*";

    @Autowired
    private UploadImagenService uploadImagenService;

    @PostMapping()
    @CrossOrigin(origins = clientUrl)
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile file) throws IOException {

        Path path = uploadImagenService.createCouponPost(file);

        if (path == null) {
            return new ResponseEntity<>("Format not supported", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(path, HttpStatus.OK);
    }
}
