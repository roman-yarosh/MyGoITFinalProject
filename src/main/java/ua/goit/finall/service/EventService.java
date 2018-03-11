package ua.goit.finall.service;

import ua.goit.finall.model.Event;

import java.util.List;

public interface EventService{

    Event getById(Long id);

    void save(Event event);

    void delete(Long id);

    List<Event> getAll();

}
