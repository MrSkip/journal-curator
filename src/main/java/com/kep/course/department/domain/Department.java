package com.kep.course.department.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kep.course.entity.BaseEntity;
import com.kep.course.group.domain.Group;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

/**
 * by Mr Skip on 10.03.2016.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "idDepartment")
    private Long id;
    private String name;
    private String pibOfHead;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Group> groups;

    public Department() {
    }

    public Department(
            String name,
            String pibOfHead
    ) {
        this.name = name;
        this.pibOfHead = pibOfHead;
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

    public String getPibOfHead() {
        return pibOfHead;
    }

    public void setPibOfHead(String pibOfHead) {
        this.pibOfHead = pibOfHead;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + id +
                ", name='" + name + '\'' +
                ", pibOfHead='" + pibOfHead + '\'' +
                '}';
    }
}
