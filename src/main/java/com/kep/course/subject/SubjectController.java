package com.kep.course.subject;

import com.kep.course.access.rest.RestBase;
import com.kep.course.subject.domain.Subject;
import com.kep.course.subject.service.impl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * by Mr Skip on 17.03.2016.
 */
@RestController
@RequestMapping("/subject")
public class SubjectController extends RestBase<Subject> {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        super(subjectService);
        this.subjectService = subjectService;
    }

}
