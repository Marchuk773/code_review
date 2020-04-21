package ua.lviv.iot.springfirst.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.springfirst.rest.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
