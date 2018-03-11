package ua.goit.finall.service;

import ua.goit.finall.model.Role;

import java.util.List;

public interface RoleService {

    Role getById(Long id);

    void save(Role role);

    void delete(Long id);

    List<Role> getAll();

}
