package com.kep.course.department.repository;

import com.kep.course.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Set;

/**
 * by Mr Skip on 13.03.2016.
 */

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    @SuppressWarnings("JpaQlInspection")
    @Query("select g.curatorName from Group g, Department d " +
            "where d.name = :departmentName and g.department = d.id")
    Set<String> findAllCuratorsForDepartment(@Param("departmentName") String departmentName);
}
