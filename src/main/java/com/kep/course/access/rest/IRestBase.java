package com.kep.course.access.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * by Mr Skip on 21.03.2016.
 */
public interface IRestBase<S> {

    ResponseEntity<S> update(@RequestBody S s);
    ResponseEntity delete(@PathVariable Integer id);
    ResponseEntity<S> getOne(@PathVariable Integer id);
    ResponseEntity<List<S>> getAll();
    ResponseEntity<S> save(@RequestBody S s);

}
