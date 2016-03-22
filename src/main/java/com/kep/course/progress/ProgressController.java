package com.kep.course.progress;

import com.kep.course.access.rest.RestBase;
import com.kep.course.progress.domain.Progress;
import com.kep.course.progress.service.ProgressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * by Mr Skip on 17.03.2016.
 */
@RestController
@RequestMapping("/progress")
public class ProgressController extends RestBase<Progress> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private ProgressService progressService;

    @Autowired
    public ProgressController(ProgressService progressService){
        super(progressService);
        this.progressService = progressService;
    }

    @RequestMapping(value = "/{groupName}",method = RequestMethod.GET)
    public ResponseEntity<Set<Progress>> getForGroupName(@PathVariable String groupName){
        Set<Progress> progressSet = progressService.getProgtressForOneGroup(groupName);
        if (progressSet == null || progressSet.isEmpty()) {
            log.info("Not find any progress for group `{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(progressSet);
    }

}
