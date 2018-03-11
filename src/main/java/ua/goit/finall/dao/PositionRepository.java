package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

}
