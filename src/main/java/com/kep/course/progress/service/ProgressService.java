package com.kep.course.progress.service;

import com.kep.course.group.repository.GroupRepo;
import com.kep.course.progress.domain.Progress;
import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.progress.repository.ProgressRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * by Mr Skip on 20.03.2016.
 */

@Service
public class ProgressService extends AccessDAO<Progress> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GroupRepo groupRepo;

    private ProgressRepo progressRepo;

    @Autowired
    public ProgressService(ProgressRepo progressRepo){
        super(progressRepo);
        this.progressRepo = progressRepo;
    }

    public Set<Progress> getProgtressForOneGroup(String groupName){
        log.info("Getting all progress for group '{}'", groupName);
        return progressRepo.getMountProgressForGroup(groupName);
    }

}
