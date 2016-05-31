/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.byivo.todolist.dao.ConfigurationDAO;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Configuration;
import rocks.byivo.todolist.services.ConfigurationService;

/**
 *
 * @author byivo
 */
@Service
@Transactional
public class ConfigurationServiceImpl extends GenericService<Configuration, Long> implements ConfigurationService {

    @Autowired
    private ConfigurationDAO dao;

    @Override
    protected IBaseActions<Configuration, Long> getDao() {
        return this.dao;
    }

}
