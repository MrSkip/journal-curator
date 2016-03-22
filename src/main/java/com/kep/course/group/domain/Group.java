package com.kep.course.group.domain;

import com.kep.course.department.domain.Department;
import com.kep.course.entity.BaseEntity;
import com.kep.course.student.domain.*;
import com.kep.course.subject.domain.Subject;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 08.03.2016.
 */

@Entity
@Table(name = "groups")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Group extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "idGroup")
    private Long id;

    private String name;
    private String codeOfSpeciality;
    private String nameOfSpeciality;
    private int course;
    private String curatorName;
    private int countOfStudents;

    @ManyToOne
    @JoinColumn(name = "idDepartment")
    private Department department;

    @OneToMany(mappedBy = "group")
    private Set<Student> studentSet;

    @ManyToMany
    @JoinTable(
            name = "groupSubject",
            joinColumns = {@JoinColumn(name = "idGroup", referencedColumnName = "idGroup")},
            inverseJoinColumns = {@JoinColumn(name = "idSubject", referencedColumnName = "idSubject")}
    )
    private List<Subject> subjectSet;

    public Group() {
    }

    public Group(
            String name,
            String codeOfSpeciality,
            String nameOfSpeciality,
            int course,
            String curatorName,
            int countOfStudents,
            Department idDepartment
    ) {
        this.name = name;
        this.codeOfSpeciality = codeOfSpeciality;
        this.nameOfSpeciality = nameOfSpeciality;
        this.course = course;
        this.curatorName = curatorName;
        this.countOfStudents = countOfStudents;
        this.department = idDepartment;
    }

    public Group setGroup(Group group){
        id = group.id;
        name = group.name;
        codeOfSpeciality = group.codeOfSpeciality;
        nameOfSpeciality = group.nameOfSpeciality;
        course = group.course;
        curatorName = group.curatorName;
        countOfStudents = group.countOfStudents;
        department = group.department;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeOfSpeciality() {
        return codeOfSpeciality;
    }

    public void setCodeOfSpeciality(String codeOfSpeciality) {
        this.codeOfSpeciality = codeOfSpeciality;
    }

    public String getNameOfSpeciality() {
        return nameOfSpeciality;
    }

    public void setNameOfSpeciality(String nameOfSpeciality) {
        this.nameOfSpeciality = nameOfSpeciality;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    public void setCountOfStudents(int countOfStudents) {
        this.countOfStudents = countOfStudents;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public List<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(List<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeOfSpeciality='" + codeOfSpeciality + '\'' +
                ", nameOfSpeciality='" + nameOfSpeciality + '\'' +
                ", course=" + course +
                ", curatorName='" + curatorName + '\'' +
                ", countOfStudents=" + countOfStudents +
                ", idDepartment=" + (getDepartment() != null ? getDepartment().getId() : "null") +
//                ", studentSet=" + studentSet +
//                ", subjectSet=" + subjectSet +
                '}';
    }
}

