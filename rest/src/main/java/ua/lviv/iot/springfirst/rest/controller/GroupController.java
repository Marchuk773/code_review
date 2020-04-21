package ua.lviv.iot.springfirst.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.springfirst.rest.business.GroupService;
import ua.lviv.iot.springfirst.rest.model.Group;
import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.findAll();
    }

}
