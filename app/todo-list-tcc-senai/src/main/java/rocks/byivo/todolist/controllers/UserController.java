/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.User;
import rocks.byivo.todolist.services.UserService;

/**
 *
 * @author byivo
 */
@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User, Long> {

    public static final String PATH = "/users";

    @Autowired
    private UserService service;

    @Override
    protected IBaseActions<User, Long> getService() {
        return this.service;
    }

    @Override
    protected String getPath() {
        return UserController.PATH;
    }

    @Override
    public ResponseEntity<User> create(@RequestBody User obj, UriComponentsBuilder ucBuilder) {
        try {
            return super.create(obj, ucBuilder);
        } catch (Exception ex) {

            Throwable t = ex.getCause();
            if ((t != null) && t instanceof ConstraintViolationException) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
