package com.kep.course.student.repository;

import com.kep.course.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Set;

/**
 * by Mr Skip on 09.03.2016.
 */

@SuppressWarnings("ALL")
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("select s from Student s, Progress p, Subject sb " +
            "where sb.name = :subjectName and " +
            "sb.id = p.subject and " +
            "p.mark <= 4 and " +
            "p.student = s.id")
    Set<Student> findWithNegativeMark(@Param("subjectName") String subjectName);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("select s from Student s, Group g, Department d " +
            "where d.name = :name and " +
            "d.id = g.department and " +
            "g.id = s.group and " +
            "s.benefit is not null")
    Set<Student> findWithBenefitForDepartment(@Param("name") String departmentName);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("select s from Student s, Group g " +
            "where g.name = :name and " +
            "g.id = s.group and " +
            "s.benefit is not null")
    Set<Student> findWithBenefitForGroup(@Param("name") String groupName);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Set<Student> findByCountOfReprimandIsNotNull();

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query(value = "select s.* from student s, groups g, department d " +
            "where d.name = :departmentName and " +
            "d.id_department = g.id_department and " +
            "g.id_group = s.id_group and " +
            "s.date_of_born <= date_sub(current_date(), interval 18 year)",
            nativeQuery = true)
    Set<Student> findTeenagerForDepartment(@Param("departmentName") String departmentName);

    Student findByName(String StudentName);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query(value = "select distinct s.*  from student s, visiting v, groups g " +
            "where s.id_student = v.id_student " +
            "and s.id_group = g.id_group " +
            "and g.name = :groupName " +
            "and 18 <= (select count(v2.id_visiting) from visiting v2 where v2.id_student = s.id_student)",
            nativeQuery = true)
    Set<Student> findStudentsForPrevention(@Param("groupName") String groupName);

}
