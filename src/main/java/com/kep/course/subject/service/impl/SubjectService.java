package com.kep.course.subject.service.impl;

import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.group.repository.GroupRepo;
import com.kep.course.subject.domain.Subject;
import com.kep.course.subject.repository.SubjectRepo;
import com.kep.course.subject.service.ISubject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * by Mr Skip on 17.03.2016.
 */

@Service
public class SubjectService extends AccessDAO<Subject> implements ISubject {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private SubjectRepo subjectRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    public SubjectService(SubjectRepo subjectRepo){
        super(subjectRepo);
        this.subjectRepo = subjectRepo;
    }

    @Override
    public List<Subject> getAllSubjectForGroup(String groupName) {
        return groupRepo.findByName(groupName).getSubjectSet();
    }
}
