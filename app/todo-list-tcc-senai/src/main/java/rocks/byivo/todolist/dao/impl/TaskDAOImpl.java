/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.dao.impl;

import org.springframework.stereotype.Repository;
import rocks.byivo.todolist.dao.TaskDao;
import rocks.byivo.todolist.model.Task;

/**
 *
 * @author byivo
 */
@Repository
public class TaskDAOImpl extends GenericDAO<Task, Long> implements TaskDao {
    
}
