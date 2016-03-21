package com.kep.course.subject.repository;

import com.kep.course.subject.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * by Mr Skip on 13.03.2016.
 */

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

    Subject findByName(String name);

}
