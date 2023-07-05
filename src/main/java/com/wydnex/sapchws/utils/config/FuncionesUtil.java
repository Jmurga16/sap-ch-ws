package com.wydnex.sapchws.utils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Component
public class FuncionesUtil {


    @Value("${pathfile.file}")
    private String path;




    public Resource load(String filename) throws MalformedURLException {

        Path path = getPath(filename);
        Resource resource = new UrlResource(path.toUri());
        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Error , no se puede cargar el documento");
        }
        return resource;
    }


    public String copy(MultipartFile file) throws IOException {
        String uniqueFileName = UUID.randomUUID().toString().concat("_").concat(Objects.requireNonNull(file.getOriginalFilename()));
        System.out.println("path = " + path);
        Path rootPath = getPath(uniqueFileName);
        Files.copy(file.getInputStream(), rootPath);
        return uniqueFileName;
    }


    public Path getPath(String filename) {
        return Paths.get(path).resolve(filename).toAbsolutePath();
    }

}
