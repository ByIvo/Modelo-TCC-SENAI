/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.services;

import java.io.IOException;
import java.util.List;
import rocks.byivo.todolist.interfaces.IBaseActions;
import rocks.byivo.todolist.model.Task;
import rocks.byivo.todolist.model.User;

/**
 *
 * @author byivo
 */
public interface UserService extends IBaseActions<User, Long>{
    
    
    public List<Task> getUserTasks(User user);
    
    public byte[] getUserProfile(User user) throws IOException;
}
