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

    ResponseEntity<Set<Student>> getStudentsWithNegativeMark(@RequestParam String subjectName);// /negative-mark
    ResponseEntity<Set<Student>> getStudentsForPrevention(@RequestParam String groupName); // /prevention

    ResponseEntity<Set<Student>> getTeenagerStudentsForDepartment(@RequestParam String departmentName); // /teenager-in-department
    ResponseEntity<Set<Student>> getStudentsWithBenefitForDepartment(@RequestParam String departmentName); // /benefit-in-department
    ResponseEntity<Set<Student>> getStudentsWithBenefitForGroup(@RequestParam String groupName); // /benefit-in-group
    ResponseEntity<Set<Student>> getStudentsWithReprimand(); // /reprimand
    ResponseEntity<Set<Student>> getStudentsForGroup(@RequestParam String groupName); // /group

    ResponseEntity<List<StudentExtend>> getExtendInformationAboutStudent(@RequestParam String studentName); // /extend
    ResponseEntity<List<Student>> getOne(@PathVariable String name); // /{name}

}
