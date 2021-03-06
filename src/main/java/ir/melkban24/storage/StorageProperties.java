package ir.melkban24.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mehdi on 4/16/17.
 */
@Component
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location="upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
