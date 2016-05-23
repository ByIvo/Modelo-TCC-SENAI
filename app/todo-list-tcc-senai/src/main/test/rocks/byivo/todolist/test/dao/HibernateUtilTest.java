/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.test.dao;

import org.hibernate.Session;
import rocks.byivo.todolist.dao.HibernateUtil;
import rocks.byivo.todolist.entities.Task;

/**
 *
 * @author byivo
 */
public class HibernateUtilTest {
    
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Task task = new Task();
        task.setmName("Uepa");
        
        session.save(task);
        
        session.getTransaction().commit();
        session.close();
    }
}
