/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.interfaces;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author byivo
 * @param <T> is any IEntity class
 * @param <ID> is the Id data type used in Entity class
 */
public interface IBaseActions<T extends IEntity<ID>, ID> extends Serializable {

    /**
     * Create in database an new <T> object, using <ID> as id data type.
     *
     * @param obj the IEntidade object to be created in database
     * @return new <T> object with an new Identifier (<ID> data type)
     */
    public T create(T obj) throws DataAccessException;

    /**
     * Update an existing <T> object in database using its <ID> to replace info.
     *
     * @param obj is a existing <T> object in database
     * @return the updated <T> object.
     */
    public T update(T obj) throws DataAccessException;

    /**
     * Delete an <T> object in database.
     *
     * @param obj to be deleted.
     * @return the <T> obj that was deleted from database.
     */
    public T delete(ID obj) throws DataAccessException;

    /**
     * Find a specific <T> object in database by his unique <ID> identifier.
     *
     * @param id shoud be <ID> idenfitier and will find an unique result.
     * @return <T> object in <ID> identifier match case, otherwise returns null.
     */
    public T findById(ID id) throws DataAccessException;

    /**
     * Find all <T> objects in database.
     *
     * @return A <T> List objects
     */
    public List<T> list() throws DataAccessException;

    /**
     * Filter all <T> objects in database.
     *
     * @param filters A map containing all criteria filters.
     * @return A filtered <T> List by informed filters.
     */
    public List<T> list(HashMap<?, ?> filters) throws DataAccessException;
}
