package com.kep.course.visiting;

import com.kep.course.access.rest.RestBase;
import com.kep.course.visiting.domain.Visiting;
import com.kep.course.visiting.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * by Mr Skip on 17.03.2016.
 */
@RestController
@RequestMapping(value = "/visiting")
public class VisitingController extends RestBase<Visiting>{

    private VisitingService visitingService;

    @Autowired
    public VisitingController(VisitingService visitingService) {
        super(visitingService);
        this.visitingService = visitingService;
    }
}
