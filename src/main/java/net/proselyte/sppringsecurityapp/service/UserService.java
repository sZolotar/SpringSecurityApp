package net.proselyte.sppringsecurityapp.service;

import net.proselyte.sppringsecurityapp.model.User;

/**
 * Service class for {@link net.proselyte.sppringsecurityapp.model.User}
 *
 * @author Zolotar Sergii
 * @version 1.0
 */

public interface UserService {

    void save(User user);
    User findByUsename (String username);
}
