/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
public class GenericDAO<T extends IEntity<ID>, ID> implements IBaseActions<T, ID> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDAO() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public Class<T> getClazz() {
        return this.clazz;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    @Transactional
    public T create(T obj) {
        this.entityManager.persist(obj);
        return obj;
    }

    @Override
    @Transactional
    public T update(T obj) {
        this.entityManager.merge(obj);
        return obj;
    }

    @Override
    @Transactional
    public T delete(ID id) {
        T obj = this.entityManager.getReference(this.clazz, id);

        this.entityManager.remove(obj);
        return obj;
    }
    
     @Override
    @Transactional
    public T delete(T obj) {
        if(!this.entityManager.contains(obj)) {
            obj = this.entityManager.merge(obj);
        }
        
        this.entityManager.remove(obj);
        return obj;
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return this.entityManager.find(this.clazz, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> list() {
        Session session = (Session) this.entityManager.getDelegate();
        Criteria cr = session.createCriteria(this.clazz);
        return cr.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> list(HashMap<?, ?> filters) {
        Session session = (Session) this.entityManager.getDelegate();
        Criteria cr = session.createCriteria(this.clazz);
        return cr.list();
    }

}
