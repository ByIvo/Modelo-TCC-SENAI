/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.dao.impl;

import org.springframework.stereotype.Repository;
import rocks.byivo.todolist.dao.UserDAO;
import rocks.byivo.todolist.model.User;

/**
 *
 * @author byivo
 */
@Repository
public class UserDAOImpl extends GenericDAO<User, Long> implements UserDAO {

}
