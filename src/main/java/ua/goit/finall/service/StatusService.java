package ua.goit.finall.service;

import ua.goit.finall.model.Status;

import java.util.List;

public interface StatusService {

    Status getById(Long id);

    void save(Status status);

    void delete(Long id);

    List<Status> getAll();
}
