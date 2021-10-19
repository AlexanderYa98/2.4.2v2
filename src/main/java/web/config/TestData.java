package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestData {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public TestData(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addSomeUsers() {
        User user1 = new User();
        User user2 = new User();
        roleService.saveRole(new Role("ROLE_ADMIN"));
        roleService.saveRole(new Role("ROLE_USER"));
        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleService.getRoleByName("ROLE_ADMIN"));
        roles1.add(roleService.getRoleByName("ROLE_USER"));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleService.getRoleByName("ROLE_USER"));
        user1.setName("Alexander");
        user1.setPassword("373");
        user1.setRoles(roles1);
        userService.saveUser(user1);
        user2.setName("Al");
        user2.setPassword("12345");
        user2.setRoles(roles2);
        userService.saveUser(user2);
    }
}
