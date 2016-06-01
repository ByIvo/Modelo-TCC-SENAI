/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
public abstract class GenericController<T extends IEntity<ID>, ID> {

    protected abstract IBaseActions<T, ID> getService();

    protected abstract String getPath();

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<T> create(@RequestBody T obj, UriComponentsBuilder ucBuilder) {
        T newObj = this.getService().create(obj);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(this.getPath().concat("/{id}"))
                .buildAndExpand(newObj.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<T> update(@RequestBody T newObj, @PathVariable(value = "id") ID id) {
        T current = this.getService().findById(id);

        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        current.updateEntity(newObj);
        this.getService().update(current);

        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<T> delete(@PathVariable(value = "id") ID id) {

        T obj = this.getService().findById(id);

        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.getService().delete(obj);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> findById(@PathVariable(value = "id") ID id) {
        T obj = this.getService().findById(id);

        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<List<T>> list() {
        List<T> list = this.getService().list();

        HttpStatus status = list.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(list, status);
    }

}
