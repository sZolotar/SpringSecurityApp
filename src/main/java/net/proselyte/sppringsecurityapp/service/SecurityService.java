package net.proselyte.sppringsecurityapp.service;

/**
 * Service for Security
 *
 * @author Zolotar Sergii
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
