package com.kep.course.subject.service;

import com.kep.course.subject.domain.Subject;

import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 13.03.2016.
 */

public interface ISubject {

    List<Subject> getAllSubjectForGroup(String groupName); // use subjectSet in Group


}
