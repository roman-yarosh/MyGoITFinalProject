package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

}
