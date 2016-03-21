package com.kep.course.student.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kep.course.entity.BaseEntity;
import com.kep.course.progress.domain.Progress;
import com.kep.course.visiting.domain.Visiting;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.kep.course.group.domain.Group;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * by Mr Skip on 08.03.2016.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "idStudent")
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private Group group;

    private String addressOfResidence;
    private String addressOfLiving;
    private String benefit;
    private Integer countOfReprimand;
    private Date dateOfBorn;
    private String telephoneNumber;
    private String moreInformation;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Visiting> visitingSet;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Progress> progressSet;

    public Student() {
    }

    public Student(
            String name,
            Group idGroup,
            String addressOfResidence,
            String addressOfLiving,
            String benefit,
            int countOfReprimand,
            Date dateOfBorn,
            String telephoneNumber,
            String moreInformation
    ) {
        this.name = name;
        this.group = idGroup;
        this.addressOfResidence = addressOfResidence;
        this.addressOfLiving = addressOfLiving;
        this.benefit = benefit;
        this.countOfReprimand = countOfReprimand;
        this.dateOfBorn = dateOfBorn;
        this.telephoneNumber = telephoneNumber;
        this.moreInformation = moreInformation;
    }

    public Student setStudent(Student student){
        name = student.name;
        group = student.group;
        addressOfResidence = student.addressOfResidence;
        addressOfLiving = student.addressOfLiving;
        benefit = student.benefit;
        countOfReprimand = student.countOfReprimand;
        dateOfBorn = student.dateOfBorn;
        telephoneNumber = student.telephoneNumber;
        moreInformation = student.moreInformation;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getAddressOfResidence() {
        return addressOfResidence;
    }

    public void setAddressOfResidence(String addressOfResidence) {
        this.addressOfResidence = addressOfResidence;
    }

    public String getAddressOfLiving() {
        return addressOfLiving;
    }

    public void setAddressOfLiving(String addressOfLiving) {
        this.addressOfLiving = addressOfLiving;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public int getCountOfReprimand() {
        return countOfReprimand;
    }

    public void setCountOfReprimand(int countOfReprimand) {
        this.countOfReprimand = countOfReprimand;
    }

    public Date getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(Date dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    public Set<Visiting> getVisitingSet() {
        return visitingSet;
    }

    public void setVisitingSet(Set<Visiting> visitingSet) {
        this.visitingSet = visitingSet;
    }

    public Set<Progress> getProgressSet() {
        return progressSet;
    }

    public void setProgressSet(Set<Progress> progressSet) {
        this.progressSet = progressSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", addressOfResidence='" + addressOfResidence + '\'' +
                ", addressOfLiving='" + addressOfLiving + '\'' +
                ", benefit='" + benefit + '\'' +
                ", countOfReprimand=" + countOfReprimand +
                ", dateOfBorn=" + dateOfBorn +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", moreInformation='" + moreInformation + '\'' +
                '}';
    }
}
