package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    void save(Role role);

    void update(Role role);

    void delete(Long id);

    List<Role> getAllRoles();

    Role getRoleByName(String role);
}
