package net.proselyte.sppringsecurityapp.service;

import net.proselyte.sppringsecurityapp.dao.RoleDao;
import net.proselyte.sppringsecurityapp.dao.UserDao;
import net.proselyte.sppringsecurityapp.model.Role;
import net.proselyte.sppringsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface.
 *
 * @version 1.0
 *
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsename(String username) {
        return userDao.findByUsername(username);
    }
}
