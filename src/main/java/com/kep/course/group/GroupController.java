package com.kep.course.group;

import com.kep.course.group.domain.Group;
import com.kep.course.group.service.impl.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * by Mr Skip on 13.03.2016.
 */

@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService groupServe;

//    public void get(){
//        groupServe.update(new Group());
//    }
    @RequestMapping("/all")
    public List<Group> getAllGroups(){
        return groupServe.getAll();
    }
}
