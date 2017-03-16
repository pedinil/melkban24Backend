package ir.melkban24.service;

/**
 * Created by mehdi on 3/12/17.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
