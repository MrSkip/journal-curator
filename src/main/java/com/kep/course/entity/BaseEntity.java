package com.kep.course.entity;

/**
 * by Mr Skip on 19.03.2016.
 */

public class BaseEntity {

    protected Long id;
    protected Boolean activity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }
}
