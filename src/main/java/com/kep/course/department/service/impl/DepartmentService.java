package com.kep.course.department.service.impl;

import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.department.domain.Department;
import com.kep.course.department.repository.DepartmentRepo;
import com.kep.course.department.service.IDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;

/**
 * by Mr Skip on 17.03.2016.
 */

@Service
public class DepartmentService extends AccessDAO<Department> implements IDepartment{
    private final Logger log = LoggerFactory.getLogger(getClass());

    private DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo){
        super(departmentRepo);
        this.departmentRepo = departmentRepo;
    }

    @Override
    public Set<String> getAllCuratorsForDepartment(String departmentName) {
        Set<String> curators = departmentRepo.findAllCuratorsForDepartment(departmentName);
        log.info("Getting all curators name for department `{}`, size `{}`", departmentName, curators.size());
        return curators;
    }
}
