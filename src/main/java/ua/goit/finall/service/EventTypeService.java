package ua.goit.finall.service;

import ua.goit.finall.model.EventType;

import java.util.List;

public interface EventTypeService {

    EventType getById(Long id);

    void save(EventType eventType);

    void delete(Long id);

    List<EventType> getAll();

}
