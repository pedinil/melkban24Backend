package ir.melkban24.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by mehdi on 4/16/17.
 */
@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getLocation());
    }
    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException exp) {
            throw new StorageException("Could not initialize storage",exp);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file "+file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(),this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException exp) {
            throw new StorageException("Failed to store file "+ file.getOriginalFilename(),exp);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        //TODO: later
        return null;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file=load(filename);
            Resource resource=new UrlResource(file.toUri());
            if(resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: "+filename);
            }
        } catch (MalformedURLException exp) {
            throw new StorageFileNotFoundException("Could not read file: "+filename,exp);
        }
    }

    @Override
    public void deleteAll() {
        //TODO:
    }
}
