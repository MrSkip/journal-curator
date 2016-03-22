package com.kep.course.department;

import com.kep.course.access.rest.RestBase;
import com.kep.course.department.domain.Department;
import com.kep.course.department.service.impl.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * by Mr Skip on 17.03.2016.
 */

@RestController
@RequestMapping("/department")
public class DepartmentController extends RestBase<Department>{
    private final Logger log = LoggerFactory.getLogger(getClass());

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        super(departmentService);
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/curator",method = RequestMethod.GET)
    public ResponseEntity<Set<String>> getAllCuratorsForDepartment(@RequestParam String name){
        Set<String> curators = departmentService.getAllCuratorsForDepartment(name);
        if (curators == null || curators.isEmpty()) {
            log.info("Not find any curators in department `{}`", name);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(curators);
    }

}
