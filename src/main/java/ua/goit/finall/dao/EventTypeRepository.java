package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.EventType;

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, Long>{

}
