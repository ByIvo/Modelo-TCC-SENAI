/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.model.User;
import rocks.byivo.todolist.services.TaskService;

/**
 *
 * @author byivo
 */
@RestController()
@RequestMapping("/tasks")
public class TaskController extends GenericController<Task, Long>{

    public static final String PATH= "/tasks";
    
    @Autowired
    private TaskService service;

    @Override
    protected IBaseActions<Task, Long> getService() {
        return this.service;
    }

    @Override
    protected String getPath() {
        return TaskController.PATH;
    }
    
     @RequestMapping(value = "/{id}/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllTasks(@PathVariable(value = "id") Long id) {
        Task task = service.findById(id);

        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<User> userTasks = this.service.getTaskUsers(task);

        HttpStatus status = userTasks.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(userTasks, status);
    }
   
}
