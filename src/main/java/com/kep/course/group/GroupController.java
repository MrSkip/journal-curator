package com.kep.course.group;

import com.kep.course.access.rest.RestBase;
import com.kep.course.group.domain.Group;
import com.kep.course.group.service.impl.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * by Mr Skip on 13.03.2016.
 */

@RestController
@RequestMapping(value = "/group")
public class GroupController extends RestBase<Group> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private GroupService groupServe;

    @Autowired
    public GroupController(GroupService groupServe){
        super(groupServe);
        this.groupServe = groupServe;
    }

    @RequestMapping(value = "/{groupName}", method = RequestMethod.GET)
    public ResponseEntity<Group> getByGroupName(@PathVariable String groupName){
        Group group = groupServe.getGroup(groupName);
        if (group == null) {
            log.info("Not find any group with name `{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(group);
    }
}
