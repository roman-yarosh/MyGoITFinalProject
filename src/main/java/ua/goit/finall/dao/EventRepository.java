package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}