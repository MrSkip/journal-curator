package com.kep.course.student.controller;

import com.kep.course.student.domain.Student;
import com.kep.course.student.domain.StudentExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 22.03.2016.
 */

public interface IStudentController {

    ResponseEntity<Set<Student>> getStudentsWithNegativeMark(@RequestParam String subjectName);
    ResponseEntity<Set<Student>> getStudentsForPrevention(@RequestParam String groupName);
    ResponseEntity<Set<Student>> getTeenagerStudentsForDepartment(@PathVariable String departmentName);
    ResponseEntity<Set<Student>> getStudentsWithBenefitForDepartment(@PathVariable String departmentName);
    ResponseEntity<Set<Student>> getStudentsWithBenefitForGroup(@PathVariable String groupName);
    ResponseEntity<Set<Student>> getStudentsWithReprimand();
    ResponseEntity<Set<Student>> getStudentsForGroup(@PathVariable String groupName);
    ResponseEntity<StudentExtend> getExtendInformationAboutStudent(@PathVariable Long id);
    ResponseEntity<List<Student>> getOne(@PathVariable String name);

}
