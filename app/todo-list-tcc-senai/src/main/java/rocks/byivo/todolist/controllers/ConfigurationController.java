/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Configuration;
import rocks.byivo.todolist.services.ConfigurationService;

/**
 *
 * @author byivo
 */
@RestController
@RequestMapping("/configurations")
public class ConfigurationController extends GenericController<Configuration, Long> {

    public static final String PATH = "/configurations";

    @Autowired
    private ConfigurationService service;

    @Override
    protected IBaseActions<Configuration, Long> getService() {
        return this.service;
    }

    @Override
    protected String getPath() {
        return ConfigurationController.PATH;
    }
}
