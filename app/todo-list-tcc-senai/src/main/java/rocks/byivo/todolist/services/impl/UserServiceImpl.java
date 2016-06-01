/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.byivo.todolist.dao.UserDAO;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.model.User;
import rocks.byivo.todolist.services.UserService;
import rocks.byivo.todolist.util.PathUtils;

/**
 *
 * @author byivo
 */
@Service
@Transactional
public class UserServiceImpl extends GenericService<User, Long> implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ServletContext context;

    @Override
    protected IBaseActions<User, Long> getDao() {
        return this.userDao;
    }

    @Override
    public List<Task> getUserTasks(User user) {
        return this.userDao.getUserTasks(user);
    }

    @Override
    public byte[] getUserProfile(User user) throws IOException{
        InputStream in = context.getResourceAsStream(PathUtils.IMG_PROFILE);
        return IOUtils.toByteArray(in);
    }

}
