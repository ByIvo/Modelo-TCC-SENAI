/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.byivo.todolist.dao.TaskDao;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.services.TaskService;

/**
 *
 * @author byivo
 */
@Service
@Transactional
public class TaskServiceImpl extends GenericService<Task, Long> implements TaskService {

    @Autowired
    private TaskDao taskDAO;

    @Override
    protected IBaseActions<Task, Long> getDao() {
        return this.taskDAO;
    }
}
