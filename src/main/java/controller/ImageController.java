package controller;

import business.ImageService;
import constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/imagen")
public class ImageController {
    final static String clientUrl = "*";

    @Autowired
    private ImageService imageService;

    @PostMapping()
    @CrossOrigin(origins = clientUrl)
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile file) throws IOException {

        Path path = imageService.createCouponPost(file);

        if (path == null) {
            return new ResponseEntity<>("Format not supported", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(path, HttpStatus.OK);
    }


    @GetMapping()
    @CrossOrigin(origins = clientUrl)
    public ResponseEntity<?> getImage(
            @RequestParam("path") String path) throws IOException {

        Path file_path = Paths.get(Constants.IMAGE_PATH, path);

        byte[] img = Files.readAllBytes(file_path);
        return new ResponseEntity<>(img, HttpStatus.OK);
    }
}
