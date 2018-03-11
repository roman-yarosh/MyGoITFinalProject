package ua.goit.finall.service;

import ua.goit.finall.model.Position;

import java.util.List;

public interface PositionService {

    Position getById(Long id);

    void save(Position position);

    void delete(Long id);

    List<Position> getAll();

}
