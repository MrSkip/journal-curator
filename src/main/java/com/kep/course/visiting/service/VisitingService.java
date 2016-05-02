package com.kep.course.visiting.service;

import com.kep.course.visiting.domain.Visiting;
import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.visiting.repository.VisitingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * by Mr Skip on 20.03.2016.
 */

@Service
public class VisitingService extends AccessDAO<Visiting> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private VisitingRepo visitingRepo;

    @Autowired
    public VisitingService(VisitingRepo visitingRepo){
        super(visitingRepo);
        this.visitingRepo = visitingRepo;
    }

    public Set<Visiting> getWeekVisitingForGroup(String groupName){
        Date lastWorkDayOfWeek = Calendar.getInstance().getTime();
        log.info("Getting visiting for group '{}' with last work day of week '{}'", groupName, lastWorkDayOfWeek);
        return visitingRepo.getVisitingForGroup(groupName, lastWorkDayOfWeek);
    }

    public Set<Visiting> getMonthVisitingForGroup(String groupName){
        Date lastDayOfMonth = Calendar.getInstance().getTime();
        log.info("Getting visiting for group '{}' with last work day of month '{}'", groupName, lastDayOfMonth);
        return visitingRepo.getVisitingForGroup(groupName, lastDayOfMonth);
    }

}
