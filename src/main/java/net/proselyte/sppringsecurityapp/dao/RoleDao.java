package net.proselyte.sppringsecurityapp.dao;

import net.proselyte.sppringsecurityapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {


}
