/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rocks.byivo.todolist.dao.TaskDAO;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.model.TaskUser;
import rocks.byivo.todolist.model.User;

/**
 *
 * @author byivo
 */
@Repository
public class TaskDAOImpl extends GenericDAO<Task, Long> implements TaskDAO {
    
    @Override
    @Transactional(readOnly = true)
    public List<User> getTaskUsers(Task task) {
        Session session = (Session) this.getEntityManager().getDelegate();
        Criteria cr = session.createCriteria(TaskUser.class);
        
        cr.setProjection(Projections.property("user"));
        cr.add(Restrictions.eq("task", task));
        
        return cr.list();
    }
}
