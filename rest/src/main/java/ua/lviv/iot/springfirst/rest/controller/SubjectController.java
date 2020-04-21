package ua.lviv.iot.springfirst.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.springfirst.rest.business.SubjectService;
import ua.lviv.iot.springfirst.rest.model.Subject;
import java.util.List;

@RequestMapping("/subjects")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllGroups() {
        return subjectService.findAll();
    }

}
