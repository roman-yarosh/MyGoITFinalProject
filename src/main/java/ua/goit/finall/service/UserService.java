package ua.goit.finall.service;

import ua.goit.finall.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    void save(User user);

    void delete(Long id);

    List<User> getAll();

}
