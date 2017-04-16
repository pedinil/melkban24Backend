package ir.melkban24.storage;

/**
 * Created by mehdi on 4/16/17.
 */
public class StorageException extends RuntimeException{
    public  StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
