package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
