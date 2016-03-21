package com.kep.course.student;

import com.kep.course.group.service.impl.GroupService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * by Mr Skip on 09.03.2016.
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController {

//    @Autowired
//    private GroupService service;

//    @RequestMapping(
//            value = "/getGroups",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List getAllBusName(){
//        return service.getAllGroups();
//    }
}
