/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
public abstract class GenericService<T extends IEntity<ID>,ID> implements IBaseActions<T, ID>{
    
    @Override
    public T create(T obj) throws DataAccessException {
        return this.getDao().create(obj);
    }

    @Override
    public T update(T obj) throws DataAccessException {
       return this.getDao().update(obj);
    }

    @Override
    public T delete(ID obj) throws DataAccessException {
        return this.getDao().delete(obj);
    }

    @Override
    public T findById(ID id) throws DataAccessException {
        return this.getDao().findById(id);
    }

    @Override
    public List<T> list() throws DataAccessException {
        return this.getDao().list();
    }

    @Override
    public List<T> list(HashMap<?, ?> filters) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected abstract IBaseActions<T, ID> getDao();
}
