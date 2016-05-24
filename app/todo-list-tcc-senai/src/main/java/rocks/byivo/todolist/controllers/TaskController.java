/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.services.TaskService;

/**
 *
 * @author byivo
 */
@Controller()
@RequestMapping("/tasks")
public class TaskController extends GenericController<Task, Long>{

    @Autowired
    private TaskService taskService;

    @Override
    protected IBaseActions<Task, Long> getService() {
        return this.taskService;
    }
   
}
