package com.kep.course.subject;

import com.kep.course.access.rest.RestBase;
import com.kep.course.subject.domain.Subject;
import com.kep.course.subject.service.impl.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * by Mr Skip on 17.03.2016.
 */
@RestController
@RequestMapping("/subject")
public class SubjectController extends RestBase<Subject> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        super(subjectService);
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getAllSubjectForGroup(@RequestParam String groupName) {
        List<Subject> subjects = subjectService.getAllSubjectForGroup(groupName);
        if (subjects == null || subjects.isEmpty()) {
            log.info("Not find any subject for group `{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(subjects);
    }

}
