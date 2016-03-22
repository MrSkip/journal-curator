package com.kep.course.student.service;

import com.kep.course.student.domain.Student;
import com.kep.course.student.domain.StudentExtend;

import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 10.03.2016.
 */

public interface IStudent {

    Set<Student> getStudentsWithNegativeMark(String subjectName); // use Query +

    Set<Student> getStudentsForPrevention(String groupName); // use Query

    Set<Student> getTeenagerStudentsForDepartment(String departmentName); // use Query

    Set<Student> getStudentsWithBenefitForDepartment(String departmentName); // use Query

    Set<Student> getStudentsWithBenefitForGroup(String groupName); // use Query

    Set<Student> getStudentsWithReprimand();

    Set<Student> getStudentsForGroup(String groupName);

    StudentExtend getFullInformationAboutStudent(Long id);

    List<Student> getByName(String name);

}