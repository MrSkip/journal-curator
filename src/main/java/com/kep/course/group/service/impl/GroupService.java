package com.kep.course.group.service.impl;

import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.exception.ExceptionMySQL;
import com.kep.course.group.domain.Group;
import com.kep.course.group.repository.GroupRepo;
import com.kep.course.group.service.IGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * by Mr Skip on 09.03.2016.
 */

@Service
public class GroupService extends AccessDAO<Group> implements IGroup{
    private final Logger log = LoggerFactory.getLogger(getClass());

    private GroupRepo groupRepo;

    @Autowired
    public GroupService(GroupRepo groupRepo){
        super(groupRepo);
        this.groupRepo = groupRepo;
    }

    @Override
    public Group getGroup(String name) {
        log.info("Find group with name `{}`", name);
        Group group = groupRepo.findByName(name);

        if (group == null)
            throw new ExceptionMySQL("Can`t find group with name '" + name + "'");

        return group;
    }

}
