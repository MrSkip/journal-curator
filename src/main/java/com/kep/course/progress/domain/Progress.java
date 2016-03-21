package com.kep.course.progress.domain;

import com.kep.course.entity.BaseEntity;
import com.kep.course.student.domain.Student;
import com.kep.course.subject.domain.Subject;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * by Mr Skip on 08.03.2016.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Progress extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "idProgress")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idStudent")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "idSubject")
    private Subject subject;

    private Date date;
    private int mark;
    private String kindOfLesson;

    public Progress() {
    }

    public Progress(
            Student idStudent,
            Subject idSubject,
            Date date,
            int mark,
            String kindOfLesson
    ) {
        this.student = idStudent;
        this.subject = idSubject;
        this.date = date;
        this.mark = mark;
        this.kindOfLesson = kindOfLesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getKindOfLesson() {
        return kindOfLesson;
    }

    public void setKindOfLesson(String kindOfLesson) {
        this.kindOfLesson = kindOfLesson;
    }
}
