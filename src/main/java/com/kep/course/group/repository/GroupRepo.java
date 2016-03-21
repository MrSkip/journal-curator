package com.kep.course.group.repository;

import com.kep.course.group.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * by Mr Skip on 09.03.2016.
 */

@Repository
public interface GroupRepo extends JpaRepository<Group, Integer> {

    Group findByName(String name);

}