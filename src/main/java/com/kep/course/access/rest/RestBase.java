package com.kep.course.access.rest;

import com.kep.course.access.jpa.AccessDAO;
import com.kep.course.entity.BaseEntity;
import com.kep.course.exception.ExceptionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * by Mr Skip on 21.03.2016.
 */

public class RestBase<S extends BaseEntity> implements IRestBase<S>{
    protected Logger log = LoggerFactory.getLogger(getClass());

    private AccessDAO accessDAO;

    public RestBase(AccessDAO accessDAO){
        this.accessDAO = accessDAO;
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<S> update(@RequestBody S s) {
        S update;
        try {
            update = (S) accessDAO.update(s);
            if (update == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ExceptionMySQL e){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .header("MySQL Exception", e.getMessage())
                    .body(null);
        }
        return ResponseEntity.ok(update);
    }
    
    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            accessDAO.delete(id);
        } catch (ExceptionMySQL e){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .header("MySQL Exception", e.getMessage())
                    .build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<S> getOne(@PathVariable Integer id) {
        S find;
        try {
            find = (S) accessDAO.getOne(id);
        } catch (ExceptionMySQL e){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .header("MySQL Exception", e.getMessage())
                    .body(null);
        }
        return ResponseEntity.ok(find);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<S>> getAll() {
        List<S> list = accessDAO.getAll();
        if (list.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(null);
        return ResponseEntity.ok(list);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<S> save(@RequestBody S s) {
        S save;
        try {
            save = (S) accessDAO.save(s);
        } catch (ExceptionMySQL e){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .header("MySQL Exception", e.getMessage())
                    .body(null);
        }
        return ResponseEntity.ok(save);
    }
}