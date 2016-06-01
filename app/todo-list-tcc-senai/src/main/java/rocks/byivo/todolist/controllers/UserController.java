/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import java.io.IOException;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
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

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable(value = "id") Long id) {
        User user = service.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Task> userTasks = this.service.getUserTasks(user);

        HttpStatus status = userTasks.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(userTasks, status);
    }

    @RequestMapping(value = "/{id}/profile", method = RequestMethod.GET, produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<byte[]> getUserImagem(@PathVariable(value = "id") Long id) throws IOException {
        User user = service.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        byte[] userProfile = service.getUserProfile(user);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

}
