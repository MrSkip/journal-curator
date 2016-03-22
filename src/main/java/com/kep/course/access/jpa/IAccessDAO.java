package com.kep.course.access.jpa;

import java.util.List;

/**
 * by Mr Skip on 19.03.2016.
 */

public interface IAccessDAO<S> {

    S update(S s);
    void delete(Integer id);
    S getOne(Integer id);
    List<S> getAll();
    S save(S s);

}
