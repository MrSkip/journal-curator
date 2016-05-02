package com.kep.course.student.service.impl;

import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.exception.ExceptionMySQL;
import com.kep.course.group.repository.GroupRepo;
import com.kep.course.student.domain.Student;
import com.kep.course.student.domain.StudentExtend;
import com.kep.course.student.repository.StudentRepo;
import com.kep.course.student.service.IStudent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * by Mr Skip on 10.03.2016.
 */

@Service
public class StudentService extends AccessDAO<Student> implements IStudent {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private StudentRepo studentRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo){
        super(studentRepo);
        this.studentRepo = studentRepo;
    }

    @Override
    public Set<Student> getStudentsWithNegativeMark(String subjectName) {
        log.info("Getting students with negative mark for subject name '{}'", subjectName);
        return studentRepo.findWithNegativeMark(subjectName);
    }

    @Override
    public Set<Student> getStudentsForPrevention(String groupName) {
        log.info("Getting students for prevention with group name '{}'", groupName);
        return studentRepo.findStudentsForPrevention(groupName);
    }

    @Override
    public Set<Student> getTeenagerStudentsForDepartment(String departmentName) {
        log.info("Getting students for department with name '{}'", departmentName);
        return studentRepo.findTeenagerForDepartment(departmentName);
    }

    @Override
    public Set<Student> getStudentsWithBenefitForDepartment(String departmentName) {
        log.info("Getting students with benefit for department with name '{}'", departmentName);
        return studentRepo.findWithBenefitForDepartment(departmentName);
    }

    @Override
    public Set<Student> getStudentsWithBenefitForGroup(String groupName) {
        log.info("Getting students with benefit for group with name '{}'", groupName);
        return studentRepo.findWithBenefitForGroup(groupName);
    }

    @Override
    public Set<Student> getStudentsWithReprimand() {
        log.info("Getting students with reprimand");
        return studentRepo.findByCountOfReprimandIsNotNull();
    }

    @Override
    public Set<Student> getStudentsForGroup(String groupName) {
        log.info("Getting students for group with group name '{}'", groupName);
        return groupRepo.findByName(groupName).getStudentSet();
    }

    @Override
    public List<Student> getByName(String studentName) {
        log.info("Getting students with name '{}'", studentName);
        return studentRepo.findByName(studentName);
    }

    @Override
    public List<StudentExtend> getFullInformationAboutStudent(String studentName) throws ExceptionMySQL{
        log.info("Getting full information about student with name '" + studentName + "'");
        List<Student> student = studentRepo.findByName(studentName);
        return student.stream().map(student1 -> new StudentExtend(student1)
                .setGroupAndDepartmentNames(student1.getGroup().getName(),
                        student1.getGroup().getDepartment().getName())).collect(Collectors.toList());
    }
}