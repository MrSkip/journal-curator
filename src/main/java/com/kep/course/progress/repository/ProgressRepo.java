package com.kep.course.progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kep.course.progress.domain.Progress;

import javax.persistence.QueryHint;
import java.util.Set;

/**
 * by Mr Skip on 09.03.2016.
 */

@SuppressWarnings("ALL")
@Repository
public interface ProgressRepo extends JpaRepository<Progress, Integer> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query(value = "select p.* from groups g, student s, progress p " +
            "where g.name = :groupName " +
            "and g.id_group = s.id_group " +
            "and s.id_student = p.id_student " +
            "and p.data between date_sub(current_date(), interval 1 month) and current_date()",
            nativeQuery = true)
    Set<Progress> getMountProgressForGroup(@Param("groupName") String groupName);



}
