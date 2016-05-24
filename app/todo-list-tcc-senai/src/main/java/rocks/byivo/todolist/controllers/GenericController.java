/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.interfaces.IEntity;

/**
 *
 * @author byivo
 */
public abstract class GenericController<T extends IEntity<ID>, ID> {

    protected abstract IBaseActions<T, ID> getService();

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public T create(@ModelAttribute T obj) {
        return this.getService().create(obj);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public T update(@ModelAttribute T obj) {
        return this.getService().update(obj);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public T delete(@PathVariable(value = "id") ID id) {
       return this.getService().delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T findById(@PathVariable(value = "id") ID id) {
        return this.getService().findById(id);
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<T> list() {
        return this.getService().list();
    }

}
