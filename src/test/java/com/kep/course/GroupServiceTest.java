package com.kep.course;

import com.kep.course.access.AccessDAO;
import com.kep.course.department.domain.Department;
import com.kep.course.exception.ExceptionMySQL;
import com.kep.course.group.domain.Group;
import com.kep.course.student.domain.Student;
import com.kep.course.department.repository.DepartmentRepo;
import com.kep.course.department.service.impl.DepartmentService;
import com.kep.course.group.service.impl.GroupService;
import com.kep.course.student.repository.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * by Mr Skip on 14.03.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class GroupServiceTest {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GroupService groupService;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void test(){
        log.info("\n");

        log.info("all group: {}", groupService.getAll());

        try{
//            Group group = groupService.getOne(2);
            log.info("second: {}", studentRepo.findTeenagerForDepartment("q"));
        }catch (ExceptionMySQL exceptionMySQL){
            System.out.println(exceptionMySQL + "");
        }

//        Group group = groupService.getOne(1);
//        group.setName("Anna");
//
//        groupService.update(group);

//        AccessDAO accessDAO = new AccessDAO(studentRepo);

//        ((JpaRepository<Student, Integer>) accessDAO.getRepo()).findAll();

//        Student student = studentRepo.getOne(1);
//        log.info("before : {}", student);
//
//        student.setLastName("alolo");
//        studentRepo.save(student);
//        try {
//            Thread.sleep(15_000);
//        } catch (Exception e){
//            System.out.println("Sdf");
//        }

//        log.info("after : {}", studentRepo.getOne(1));


//
//        try{
//            log.info("delete one department :");
//            departmentService.delete(3);
//        }catch (Exception e){
//            System.out.println("Ex : " + e);
//        }
//
//
//
//        try{
//            log.info("update one department :");
//            Department department = departmentService.getDepartment(2);
//            department.setName("kalin");
//            departmentService.update(department);
//        }catch (Exception e){
//            System.out.println("Ex : " + e);
//        }

//        log.info("get cur : {} ", departmentService.getAllCuratorsForDepartment("kalin"));

//        Group group = groupService.getGroup(1);
//        group.setDepartment(null);
//        group.setName("something new");

//        Group group = groupService.getGroup(1);
//
//        group.setCourse(123);
//        group.setId(0);
//        group.setName("trat-ra");
//        group.setDepartment(null);
//
//
//        try{
//            groupService.update(group);
//        }catch (ExceptionMySQL e){
//            System.out.println("Ex: " + e);
//        }

//        try {
//            groupService.save(group);
//        } catch (ExceptionMySQL e){
//            System.out.println("Sdf");
//        }


//        log.info("after: {}", group);
//        log.info("common group: {}", group);
//
//        group.setName("newGroup");
//        groupService.update(group);
//
//        log.info("updated group: {}", groupService.getGroup(1));

//        Department department = departmentRepo.findOne(1);
//        log.info("groups from department 1 : {}", department.getGroups());
//
//        Group group = new Group();
//        group.setDepartment(department);
//
//        groupService.save(group);
//        department = departmentRepo.findOne(1);

//        log.info("groups from department 1 : {}", departmentRepo.findOne(1));
//        try {
//            Thread.sleep(15_000);                 //1000 milliseconds is one second.
//        } catch(InterruptedException ex) {
//            Thread.currentThread().interrupt();
//        }
//        log.info("groups from department 2 : {}", departmentRepo.findOne(1).getGroups());

//        log.info("Mika: {}", departmentRepo.findAllCuratorsForDepartment("Mika"));
//        log.info("Group : {}", departmentRepo.getGroup("12"));

//        Department department = departmentRepo.findAll().get(0);
//        department.setName("sdf");
//        Group group = new Group();
//        group.setDepartment(department);
//
//        groupService.save(group);

//        log.info("groups from first department: {}", department.getGroups());
//        log.info("groups from first department: {}", departmentRepo.findAll().get(0).getGroups());
    }
}
