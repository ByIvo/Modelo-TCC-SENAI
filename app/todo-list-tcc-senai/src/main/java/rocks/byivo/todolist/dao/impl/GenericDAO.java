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
        return clazz;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    @Transactional
    public T create(T obj) {
        entityManager.persist(obj);
        return obj;
    }

    @Override
    @Transactional
    public T update(T obj) {
        return obj;
    }

    @Override
    @Transactional
    public T delete(ID obj) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> list() {
        List<T> list = new ArrayList();        
        list.add(null);
        list.add(null);
        list.add(null);
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> list(HashMap<?, ?> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
