package com.kep.course.department.service;

import com.kep.course.department.domain.Department;

import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 13.03.2016.
 */
public interface IDepartment {

    Set<String> getAllCuratorsForDepartment(String departmentName);

}
