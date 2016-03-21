package com.kep.course.visiting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kep.course.visiting.domain.Visiting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Date;
import java.util.Set;

/**
 * by Mr Skip on 17.03.2016.
 */

@Repository
public interface VisitingRepo extends JpaRepository<Visiting,Integer>{

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query(value = "select v.* from visiting v, student s, groups g " +
            "where g.name = :groupName " +
            "and g.id_group = s.id_group " +
            "and s.id_student = v.id_student " +
            "v.date between date_sub(:lastDayOfWeek, interval 5 day) and :lastDayOfWeek",
            nativeQuery = true)
    Set<Visiting> getVisitingForGroup(@Param("groupName") String groupName,
                                      @Param("lastDayOfWeek") Date lastDayOfWeek);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query(value = "select v.* from visiting v, student s, groups g " +
            "where g.name = :groupName " +
            "and g.id_group = s.id_group " +
            "and s.id_student = v.id_student " +
            "v.date between date_sub(:lastDayOfWeek, interval 1 month) and :lastDayOfWeek",
            nativeQuery = true)
    Set<Visiting> getVisitingForDepartment(@Param("groupName") String groupName,
                                      @Param("lastDayOfWeek") Date lastDayOfMount);

}
