package com.kep.course.visiting;

import com.kep.course.access.rest.RestBase;
import com.kep.course.visiting.domain.Visiting;
import com.kep.course.visiting.service.VisitingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Set;

/**
 * by Mr Skip on 17.03.2016.
 */

@RestController
@RequestMapping(value = "/visiting")
public class VisitingController extends RestBase<Visiting>{
    private final Logger log = LoggerFactory.getLogger(getClass());

    private VisitingService visitingService;

    @Autowired
    public VisitingController(VisitingService visitingService) {
        super(visitingService);
        this.visitingService = visitingService;
    }

    @RequestMapping(value = "/week", method = RequestMethod.GET)
    public ResponseEntity<Set<Visiting>> getWeekVisitingForGroup(@RequestParam String groupName){
        Set<Visiting> set = visitingService.getWeekVisitingForGroup(groupName);
        if (set == null || set.isEmpty()) {
            log.info("Not find any visiting for group`{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(set);
    }

    @RequestMapping(value = "/month",method = RequestMethod.GET)
    public ResponseEntity<Set<Visiting>> getMonthVisitingForGroup(@RequestParam String groupName){
        Set<Visiting> set = visitingService.getMonthVisitingForGroup(groupName);
        if (set == null) {
            log.info("Not find any visiting for group`{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(set);
    }

}
