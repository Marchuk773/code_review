package ua.lviv.iot.springfirst.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.springfirst.rest.dataaccess.SubjectRepository;
import ua.lviv.iot.springfirst.rest.model.Subject;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

}
