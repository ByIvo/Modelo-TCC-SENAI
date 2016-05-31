/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.byivo.todolist.dao.UserDAO;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.User;
import rocks.byivo.todolist.services.UserService;

/**
 *
 * @author byivo
 */
@Service
@Transactional
public class UserServiceImpl extends GenericService<User, Long> implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    protected IBaseActions<User, Long> getDao() {
        return this.userDao;
    }
}
