package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
