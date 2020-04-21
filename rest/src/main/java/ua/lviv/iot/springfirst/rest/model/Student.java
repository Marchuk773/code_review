package ua.lviv.iot.springfirst.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedNativeQuery(name = "Student.findBestStudent", query = "select * from student where id = 1")
public class Student {

    private String firstName;

    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties("students")
    private Group group;

    @JsonIgnoreProperties("students")
    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects;

    public Student() {

    }

    public Student(String firstName, String secondStudent) {
        this.firstName = firstName;
        this.lastName = secondStudent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}