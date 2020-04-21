package ua.lviv.iot.springfirst.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.springfirst.rest.dataaccess.GroupRepository;
import ua.lviv.iot.springfirst.rest.model.Group;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
