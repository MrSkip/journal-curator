package com.kep.course.student.controller;

import com.kep.course.student.domain.Student;
import com.kep.course.access.rest.RestBase;
import com.kep.course.student.domain.StudentExtend;
import com.kep.course.student.service.impl.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 09.03.2016.
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController extends RestBase<Student> implements IStudentController{
    private final Logger log = LoggerFactory.getLogger(getClass());

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        super(studentService);
        this.studentService = studentService;
    }

    @Override
    @RequestMapping(params = "name",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getOne(@RequestParam String name) {
        List<Student> students = studentService.getByName(name);
        if (students == null || students.isEmpty()) {
            log.info("Not find any student for group `{}`", name);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/extend", method = RequestMethod.GET)
    public ResponseEntity<List<StudentExtend>> getExtendInformationAboutStudent(@RequestParam String studentName) {
        List<StudentExtend> student = studentService.getFullInformationAboutStudent(studentName);
        if (student == null) {
            log.info("Not find any student with name `{}`", studentName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(student);
    }

    @Override
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getStudentsForGroup(@RequestParam String groupName) {
        Set<Student> students = studentService.getStudentsForGroup(groupName);
        if (students == null || students.isEmpty()) {
            log.info("Not find any student for group `{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/reprimand", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getStudentsWithReprimand() {
        Set<Student> students = studentService.getStudentsWithReprimand();
        if (students == null || students.isEmpty()) {
            log.info("Not find any student with reprimand");
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/benefit-in-group", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getStudentsWithBenefitForGroup(@RequestParam String groupName) {
        Set<Student> students = studentService.getStudentsWithBenefitForGroup(groupName);
        if (students == null || students.isEmpty()) {
            log.info("Not find any student with benefit for group `{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/benefit-in-department", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getStudentsWithBenefitForDepartment(@RequestParam String departmentName) {
        Set<Student> students = studentService.getStudentsWithBenefitForDepartment(departmentName);
        if (students == null || students.isEmpty()) {
            log.info("Not find any student with benefit for department `{}`", departmentName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/teenager-in-department", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getTeenagerStudentsForDepartment(@RequestParam String departmentName) {
        Set<Student> students = studentService.getTeenagerStudentsForDepartment(departmentName);
        if (students == null || students.isEmpty()) {
            log.info("Not find any teenager in department `{}`", departmentName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/prevention", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getStudentsForPrevention(@RequestParam String groupName) {
        Set<Student> students = studentService.getStudentsForPrevention(groupName);
        if (students == null || students.isEmpty()) {
            log.info("Not find any student for prevention in group `{}`", groupName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }

    @Override
    @RequestMapping(value = "/negative-mark", method = RequestMethod.GET)
    public ResponseEntity<Set<Student>> getStudentsWithNegativeMark(@RequestParam String subjectName) {
        Set<Student> students = studentService.getStudentsWithNegativeMark(subjectName);
        if (students == null || students.isEmpty()) {
            log.info("Not find any student with negative mark for subject `{}`", subjectName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);
        }
        else
            return ResponseEntity.ok(students);
    }
}
