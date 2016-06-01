/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services;

import java.util.List;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.model.User;

/**
 *
 * @author byivo
 */
public interface TaskService extends IBaseActions<Task, Long> {

    public List<User> getTaskUsers(Task task);
}
