package com.kep.course.visiting.domain;

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
public class Visiting extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "idVisiting")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idStudent")
    private Student student;

    private Date date;
    private int couple;

    @ManyToOne
    @JoinColumn(name = "idSubject")
    private Subject subject;

    private String typeOfLesson;
    private String reasonOfPass;

    public Visiting() {
    }

    public Visiting(Student idStudent,
                    Date date,
                    int couple,
                    Subject idSubject,
                    String typeOfLesson,
                    String reasonOfPass) {
        this.student = idStudent;
        this.date = date;
        this.couple = couple;
        this.subject = idSubject;
        this.typeOfLesson = typeOfLesson;
        this.reasonOfPass = reasonOfPass;
    }

    public Visiting(Visiting visiting){
        this.student = visiting.student;
        this.date = visiting.date;
        this.couple = visiting.couple;
        this.subject = visiting.subject;
        this.typeOfLesson = visiting.typeOfLesson;
        this.reasonOfPass = visiting.reasonOfPass;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCouple() {
        return couple;
    }

    public void setCouple(int couple) {
        this.couple = couple;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public String getReasonOfPass() {
        return reasonOfPass;
    }

    public void setReasonOfPass(String reasonOfPass) {
        this.reasonOfPass = reasonOfPass;
    }
}
