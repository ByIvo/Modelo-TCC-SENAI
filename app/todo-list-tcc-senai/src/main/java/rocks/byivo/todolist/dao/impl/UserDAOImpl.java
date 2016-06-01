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
import rocks.byivo.todolist.dao.UserDAO;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.model.TaskUser;
import rocks.byivo.todolist.model.User;

/**
 *
 * @author byivo
 */
@Repository
public class UserDAOImpl extends GenericDAO<User, Long> implements UserDAO {

    @Override
    @Transactional(readOnly = true)
    public List<Task> getUserTasks(User user) {
        Session session = (Session) this.getEntityManager().getDelegate();
        Criteria cr = session.createCriteria(TaskUser.class);
        
        cr.setProjection(Projections.property("task"));
        cr.add(Restrictions.eq("user", user));
        
        return cr.list();
    }

}
