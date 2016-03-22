package com.kep.course.subject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kep.course.entity.BaseEntity;
import com.kep.course.group.domain.Group;
import com.kep.course.progress.domain.Progress;
import com.kep.course.visiting.domain.Visiting;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

/**
 * by Mr Skip on 08.03.2016.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Subject extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "idSubject")
    private Long id;
    private String name;
    private String teacher;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private Set<Progress> progressSet;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private Set<Visiting> visitingSet;

    @ManyToMany(mappedBy = "subjectSet")
    @JsonIgnore
    private Set<Group> groupSet;

    public Subject() {
    }

    public Subject(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Subject(Subject subject){
        name = subject.name;
        teacher = subject.teacher;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Set<Progress> getProgressSet() {
        return progressSet;
    }

    public void setProgressSet(Set<Progress> progressSet) {
        this.progressSet = progressSet;
    }

    public Set<Visiting> getVisitingSet() {
        return visitingSet;
    }

    public void setVisitingSet(Set<Visiting> visitingSet) {
        this.visitingSet = visitingSet;
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }
}
